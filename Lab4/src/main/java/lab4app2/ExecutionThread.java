package main.java.lab4app2;

import java.util.concurrent.locks.Lock;

public class ExecutionThread extends Thread {
    private final Lock monitor1;
    private final Lock monitor2;
    private final int minActivity1;
    private final int maxActivity1;
    private final int minActivity2;
    private final int maxActivity2;
    private final int delay;

    public ExecutionThread(Lock monitor1, Lock monitor2, int minActivity1, int maxActivity1, int minActivity2, int maxActivity2, int delay) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.minActivity1 = minActivity1;
        this.maxActivity1 = maxActivity1;
        this.minActivity2 = minActivity2;
        this.maxActivity2 = maxActivity2;
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " STATE - 1");

        // Simulate activity within minActivity1 and maxActivity1 bounds
        simulateActivity(minActivity1, maxActivity1);

        // Attempt to acquire monitor1
        if (monitor1.tryLock()) {
            try {
                System.out.println(this.getName() + " STATE - 2");

                // Simulate activity within minActivity2 and maxActivity2 bounds
                simulateActivity(minActivity2, maxActivity2);

                // Attempt to acquire monitor2
                if (monitor2.tryLock()) {
                    try {
                        System.out.println(this.getName() + " STATE - 3");
                        Thread.sleep(delay * 500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        monitor2.unlock();
                    }
                }
            } finally {
                monitor1.unlock();
            }
            System.out.println(this.getName() + " STATE - 4");
        }
    }

    private void simulateActivity(int min, int max) {
        int k = (int) Math.round(Math.random() * (max - min) + min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
    }
}

