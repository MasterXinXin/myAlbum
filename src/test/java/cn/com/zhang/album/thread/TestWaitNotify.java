package cn.com.zhang.album.thread;

import java.util.Random;

/**
 * factory.wait()  会让当前线程进入factory对象的等待队列（持有factory对象标识符进入线程等待池）
 * factory.notifyAll() 会让当前线程从factory对象的等待队列中唤醒，进入可运行状态Runnable
 * 因此wait() notifyAll() 必须写在同步代码块里面，获取factory对象的锁
 *
 * 这里模拟不用同步写出来的生产者和消费者，会出现重复消费或者生产等问题
 * 注释放开使用wait() notifyAll()，保证单生产单消费
 */
public class TestWaitNotify {
    public static void main(String[] args) throws Exception {
        Factory factory = new Factory();
        Product product = new Product(factory);
        Consume consume = new Consume(factory);
        Thread thread1 = new Thread(product);
        Thread thread2 = new Thread(consume);
        thread1.start();
        thread2.start();
    }

    static class Factory{
        public boolean flag = false;//false 生产者需要生产
        public String name = "苹果";
        public int price = 0;
    }

    static class Product implements Runnable{
        public Factory factory;


        public Product(Factory factory){
            this.factory = factory;
        }

        @Override
        public void run() {
            while (true){
                try{
//                    synchronized (factory){
//                        if(!factory.flag){//需要生产
                            Thread.sleep(100);
                            Random random = new Random();
                            int anInt = random.nextInt(10);
                            factory.price = anInt;
                            System.out.println("生产者生产了"+factory.name+",价格："+factory.price);
                            factory.flag = true;
//                            factory.notifyAll();//生产完唤醒消费者消费
//                        }else{
//                            factory.wait();
//                        }
//                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consume implements Runnable{
        public Factory factory;

        public Consume(Factory factory){
            this.factory = factory;
        }

        @Override
        public void run() {
            while (true){
                try{
//                    synchronized (factory){
//                        if(factory.flag){//需要消费
                            int price = factory.price;
                            factory.price = 0;
                            System.out.println("消费者消费了"+factory.name+",价格："+price);
                            factory.flag = false;
                            Thread.sleep(100);
//                            factory.notifyAll();//消费完唤醒生产者生产
//                        }else{
//                            factory.wait();
//                        }
//                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
