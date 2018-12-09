package my.se.demo;

import java.util.concurrent.CountDownLatch;

public class Runner implements  Runnable{

    private static final CountDownLatch latch = new CountDownLatch(2);


    public static void main(String[] args) throws InterruptedException {

        System.out.println("主线程执行...1");
        new Thread(new Runner()).start();
        new Thread(new Runner()).start();
        latch.await();
        System.out.println("主线程执行...2");

    }

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + "Runner初始化...");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() +"Runner初始化结束...");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
