package cn.com.zhang.album.thread;

public class TestJoin {
    /**
     * t2.join会让当前线程进入等待队列处于阻塞状态Blocked，直到t2线程跑完才会进入可运行状态Runnable
     *
     * 这里让主线程和线程A B都使用同一个对象锁o
     * 当主线程使用t2.join，实际上相当于调用t2.wait(0),获得t2的锁并进入t2对象的等待池(进入以t2为标识符的线程池中等待)，直到t2执行完然后自动t2.notify()，主线程才会被唤醒进入可运行状态
     * 但是主线程进入t2的等待池时，并未释放同步锁o，导致t2也获取不到，从而死锁
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Object o = new Object();
        ThreadA a = new ThreadA(o);
        ThreadB b = new ThreadB(o);
        Thread t1= new Thread(a,"A");
        Thread t2= new Thread(b,"B");

        synchronized (o){
            t2.start();
            t2.join();
            t1.start();
        }


    }

    static class ThreadA implements Runnable{
        public Object o;
        public ThreadA(Object o){
            this.o = o;
        }
        @Override
        public void run() {
            System.out.println("ThreadA:"+Thread.currentThread().getName()+"is begin");
            synchronized (o){
                for (int i = 0;i < 10; i++){
                    System.out.println("ThreadA "+i);
                }
                System.out.println("ThreadA end");
            }
        }
    }

    static class ThreadB implements Runnable{
        public Object o;
        public ThreadB(Object o){
            this.o = o;
        }
        @Override
        public void run() {
            System.out.println("ThreadB:"+Thread.currentThread().getName()+"is begin");
            synchronized (o){
                for (int i = 0;i < 10; i++){
                    System.out.println("ThreadB "+i);
                }
                System.out.println("ThreadB end");
            }
        }
    }

}
