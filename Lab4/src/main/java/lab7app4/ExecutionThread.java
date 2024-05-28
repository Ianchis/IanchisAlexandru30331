package main.java.lab7app4;

import java.util.concurrent.Semaphore;

public class ExecutionThread extends Thread {
    private final int minActivity;
    private final int maxActivity;
    private final int delay;
    private final Semaphore semaphore;

    public ExecutionThread(int minActivity, int maxActivity, int delay, Semaphore semaphore) {
        this.minActivity = minActivity;
        this.maxActivity = maxActivity;
        this.delay = delay;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(this.getName() + " STATE - 1");

                // Acquire two permits from the semaphore
                semaphore.acquire(2);

                System.out.println(this.getName() + " STATE - 2 !!");

                // Simulate activity
                simulateActivity();

                // Release two permits to the semaphore
                semaphore.release(2);

                System.out.println(this.getName() + " STATE - 3");

                // Sleep to simulate delay
                Thread.sleep(delay * 500);

                System.out.println(this.getName() + " STATE - 4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to simulate activity
    private void simulateActivity() {
        int k = (int) Math.round(Math.random() * (maxActivity - minActivity) + minActivity);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
    }
}

