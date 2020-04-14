package cn.com.zhang.album.thread;

/**
 * 测试可重入锁的底层实现
 * 不可重入锁，当前线程必须上锁后释放锁，才能再次上锁
 * 可重入锁，当前线程允许上锁后继续上锁，但是必须保证释放锁的次数与上锁一致才能完全释放
 *
 * 这里让线程调用doA()上锁一次，然后doB()再上锁一次,然后依次释放锁
 * 不可重入锁必定会被阻塞
 * 可重入锁不会影响，其中可重入First线程在doB()释放锁时sleep，让可重入Second线程进行doA()进行上锁，
 * 但是因为First线程没有完全释放锁，所以Second线程会被阻塞一次，直到First线程完全释放锁才被唤醒
 */
public class TestLock {
    public static void main(String[] args) {
        Lock noneReetrantLock = new NoneReetrantLock();
        Lock reetrantLock = new ReetrantLock();
        Done done1 = new Done(noneReetrantLock);//不可重入
        Done done2 = new Done(reetrantLock);//可重入

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    done1.doA();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "不可重入")
                .start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    done2.doA();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "可重入First")
                .start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    done2.doA();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "可重入Second")
                .start();
    }

    static interface Lock{
        void lock() throws Exception;
        void unLock();
    }

    /**
     * 不可重入锁
     */
    static class NoneReetrantLock implements Lock{
        boolean isLocked = false;//false 未上锁

        public synchronized void lock() throws Exception{
            while (isLocked){
                System.out.println("线程"+Thread.currentThread().getName()+"被阻塞");
                wait();
            }
            System.out.println("线程"+Thread.currentThread().getName()+"上锁");
            isLocked = true;
        }

        public synchronized void unLock(){
            System.out.println("线程"+Thread.currentThread().getName()+"解锁");
            isLocked = false;
            notify();
        }
    }


    /**
     * 可重入锁
     * 一个线程可以重复获取锁，其他线程则等待，但是该线程必须保证加锁和解锁次数对应才能真正释放锁
     */
    static class ReetrantLock implements Lock{
        int lockedCount;//加锁次数 为0时代表未加锁
        boolean isLocked = false;//false 未上锁
        Thread lockedThread = null;//哪个线程上锁

        public synchronized void lock() throws Exception{
            Thread thread = Thread.currentThread();
            while (isLocked && lockedThread != thread){
                //如果其他线程访问，发现上锁了，并且上锁的线程不是他自己，则阻塞等待
                System.out.println("线程"+Thread.currentThread().getName()+"被阻塞");
                wait();
            }
            //当前线程可重复上锁
            lockedCount++;
            System.out.println("线程"+Thread.currentThread().getName()+"上锁"+lockedCount+"次");
            isLocked = true;
            lockedThread = thread;
        }

        public synchronized void unLock(){
            Thread thread = Thread.currentThread();
            if(thread == lockedThread){
                //被上锁线程访问才能解锁
                System.out.println("线程"+Thread.currentThread().getName()+"解锁"+lockedCount+"次");
                lockedCount--;
                if (lockedCount == 0){
                    System.out.println("线程"+Thread.currentThread().getName()+"完全解锁");
                    isLocked = false;
                    notify();
                }
            }
        }
    }

    static class Done{
        Lock lock;
        public Done(Lock lock){
            this.lock = lock;
        }

        public void doA() throws Exception{
            lock.lock();
            doB();
            lock.unLock();
        }

        public void doB() throws Exception{
            lock.lock();
            System.out.println("线程"+Thread.currentThread().getName()+"doB");
            Thread.sleep(50);
            lock.unLock();
        }
    }
}
