package cn.com.zhang.album.thread;

public class TestJoin {
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
