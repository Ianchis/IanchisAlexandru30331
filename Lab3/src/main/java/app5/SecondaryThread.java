package main.java.app5;

public class SecondaryThread extends Thread {
    private final int delay;
    private final int minActivity;
    private final int maxActivity;
    private final Object monitor;
    private final MainThread mainThread;

    public SecondaryThread(int minActivity, int maxActivity, int delay, Object monitor, MainThread mainThread) {
        this.delay = delay;
        this.minActivity = minActivity;
        this.maxActivity = maxActivity;
        this.monitor = monitor;
        this.mainThread = mainThread;
    }

    @Override
    public void run() {
        System.out.println(getName() + " - STATE 1");

        synchronized (monitor) {
            try {
                monitor.wait(); // Wait until notified by mainThread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(getName() + " - STATE 2");

        // Simulate activity within minActivity and maxActivity bounds
        int activityCount = (int) Math.round(Math.random() * (maxActivity - minActivity) + minActivity);
        for (int i = 0; i < activityCount * 100000; i++) {
            i++;
            i--;
        }

        System.out.println(getName() + " - STATE 3");

        try {
            mainThread.join(); // Wait for the mainThread to finish
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

