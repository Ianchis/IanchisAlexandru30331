package main.java.app5;

public class MainThread extends Thread {
    private final int delay;
    private final int minActivity;
    private final int maxActivity;
    private final Object monitor1;
    private final Object monitor2;

    public MainThread(int minActivity, int maxActivity, int delay, Object monitor1, Object monitor2) {
        this.delay = delay;
        this.minActivity = minActivity;
        this.maxActivity = maxActivity;
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
    }

    @Override
    public void run() {
        System.out.println(getName() + " - STATE 1");

        try {
            // Sleep for a random time up to delay milliseconds
            Thread.sleep(Math.round(Math.random() * delay * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " - STATE 2");

        // Simulate activity within minActivity and maxActivity bounds
        int activityCount = (int) Math.round(Math.random() * (maxActivity - minActivity) + minActivity);
        for (int i = 0; i < activityCount * 100000; i++) {
            i++;
            i--;
        }

        synchronized (monitor1) {
            monitor1.notifyAll(); // Notify all threads waiting on monitor1
        }

        synchronized (monitor2) {
            monitor2.notifyAll(); // Notify all threads waiting on monitor2
        }

        System.out.println(getName() + " - STATE 3");
    }
}

