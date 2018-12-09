package my.se.demo;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {
    public static void main(String[] args) {

      final  MyQueue<String> queue = new MyQueue<>(3, 5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                queue.pull("a");
                queue.pull("b");
                queue.pull("c");
                queue.pull("d");
                queue.pull("e");
                queue.pull("f");
                queue.pull("g");

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(queue.peek());
                System.out.println(queue.peek());
                System.out.println(queue.peek());
                System.out.println(queue.peek());
                System.out.println(queue.peek());
                System.out.println(queue.peek());
            }
        }).start();

    }
}


class MyQueue<T> {

    private final LinkedList<T> queue = new LinkedList<T>();

    private final int minSize;

    private final int maxSize;

    private AtomicInteger count = new AtomicInteger(0);

    private final Object lock = new Object();

    public MyQueue(int minSize, int maxSize) {
        this.maxSize = maxSize;
        this.minSize = minSize;

    }

    public void pull(T t) {
        synchronized (lock) {
            while (count.get() >= maxSize) {
                try {
                    System.out.println("pull进入等待..." + queue);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notify();
            queue.addLast(t);
            count.incrementAndGet();
        }
    }

    public T peek() {
        synchronized (lock) {


            while (queue.size() <= minSize) {
                try {
                    System.out.println("peek进入等待..." + queue);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notify();
            count.decrementAndGet();
            return queue.removeFirst();
        }

    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }
}