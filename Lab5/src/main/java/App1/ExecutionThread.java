package main.java.App1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ExecutionThread extends Thread {
    private final Semaphore P9;
    private final Semaphore P10;
    private final CyclicBarrier T8;
    private final int minActivityP1;
    private final int maxActivityP1;
    private final int minActivityP2;
    private final int maxActivityP2;
    private final int delay;

    public ExecutionThread(Semaphore P9, Semaphore P10, CyclicBarrier T8,
                           int minActivityP1, int maxActivityP1, int minActivityP2,
                           int maxActivityP2, int delay) {
        this.P9 = P9;
        this.P10 = P10;
        this.T8 = T8;
        this.minActivityP1 = minActivityP1;
        this.maxActivityP1 = maxActivityP1;
        this.minActivityP2 = minActivityP2;
        this.maxActivityP2 = maxActivityP2;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.getName() + " - STATE 1");
            try {
                // Acquire permits from P9 and P10
                this.P9.acquire(1);
                this.P10.acquire(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(this.getName() + " - STATE 2");

            // Simulate activity for P1
            simulateActivity(minActivityP1, maxActivityP1);

            System.out.println(this.getName() + " - STATE 3");

            try {
                // Sleep to simulate delay
                Thread.sleep(Math.round(Math.random() * this.delay * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Release permits to P9 and P10
            this.P9.release(1);
            this.P10.release(1);

            System.out.println(this.getName() + " - STATE 4");

            try {
                // Wait for T8 barrier
                this.T8.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to simulate activity
    private void simulateActivity(int min, int max) {
        int k = (int) Math.round(Math.random() * (max - min) + min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
    }
}

