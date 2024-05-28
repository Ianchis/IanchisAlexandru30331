package main.java.app2;

import java.util.concurrent.Semaphore;

public class Fir extends Thread {
    private final int name;
    private final int delay;
    private final int activityCount;
    private final int permit;
    private final Semaphore semaphore;

    public Fir(int name, Semaphore semaphore, int delay, int activityCount, int permit) {
        this.name = name;
        this.semaphore = semaphore;
        this.delay = delay;
        this.activityCount = activityCount;
        this.permit = permit;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Fir " + name + " - STATE 1");
                Thread.sleep(delay * 500); // Simulate delay

                System.out.println("Fir " + name + " - STATE 2");
                semaphore.acquire(permit); // Acquire semaphore permits

                System.out.println("Fir " + name + " acquired permits from the semaphore");
                System.out.println("Fir " + name + " - STATE 3");

                // Simulate activity
                for (int i = 0; i < activityCount * 100000; i++) {
                    i++;
                    i--;
                }

                semaphore.release(permit); // Release semaphore permits
                System.out.println("Fir " + name + " released permits from the semaphore");
                System.out.println("Fir " + name + " - STATE 4");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
