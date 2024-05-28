package main.java.app1;

public class ExecutionThread extends Thread {
    private final Integer monitor;
    private final int sleepMin;
    private final int sleepMax;
    private final int activityMin;
    private final int activityMax;

    public ExecutionThread(Integer monitor, int sleepMin, int sleepMax, int activityMin, int activityMax) {
        this.monitor = monitor;
        this.sleepMin = sleepMin;
        this.sleepMax = sleepMax;
        this.activityMin = activityMin;
        this.activityMax = activityMax;
    }

    @Override
    public void run() {
        System.out.println(getName() + " - STATE 1");
        try {
            // Random sleep between sleepMin and sleepMax seconds
            Thread.sleep(Math.round(Math.random() * (sleepMax - sleepMin) + sleepMin) * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " - STATE 2");
        synchronized (monitor) {
            System.out.println(getName() + " - STATE 3");
            // Simulate activity between activityMin and activityMax units
            int activityCount = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
            for (int i = 0; i < activityCount * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(getName() + " - STATE 4");
        }
    }
}

