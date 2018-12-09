package my.se.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable {

    //如果不是静态变量,在Thread类中要作为参数传入,确保是同一个才能执行.
    final  static CyclicBarrier barrier = new CyclicBarrier(4);

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            new  Thread(new Worker()).start();
        }
    }


    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + "开始准备...");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "准备完毕");
            barrier.await();
            System.out.println("开始执行后处理...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
