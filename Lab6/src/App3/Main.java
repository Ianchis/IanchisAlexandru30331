package App3;

import java.util.concurrent.CountDownLatch;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Integer monitorP6 = new Integer(1);
        Integer monitorP10 = new Integer(1);
        CountDownLatch latch = new CountDownLatch(3);
        ExecutionThread thread1 = new ExecutionThread(monitorP6, monitorP10, 7, 2, 3, latch);
        ExecutionThread1 thread2 = new ExecutionThread1(monitorP6, 5, 3, 5, thread1, latch);
        ExecutionThread2 thread3 = new ExecutionThread2(monitorP10, 5, 4, 6, thread1, latch);
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            latch.await();
        } catch (InterruptedException var8) {
            var8.printStackTrace();
        }

        System.out.println("All threads have completed their tasks.");
    }
}