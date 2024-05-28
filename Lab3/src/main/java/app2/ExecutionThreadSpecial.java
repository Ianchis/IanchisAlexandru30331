package main.java.app2;

public class ExecutionThreadSpecial extends Thread {
    private final Integer monitor1;
    private final Integer monitor2;
    private final int minActivity;
    private final int maxActivity;
    private final int delay;

    public ExecutionThreadSpecial(Integer monitor1, Integer monitor2, int minActivity, int maxActivity, int delay) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.minActivity = minActivity;
        this.maxActivity = maxActivity;
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println(getName() + " - STATE 1");
        synchronized (monitor1) {
            synchronized (monitor2) {
                System.out.println(getName() + " - STATE 2");
                // Simulate activity within minActivity and maxActivity bounds
                int activityCount = (int) Math.round(Math.random() * (maxActivity - minActivity) + minActivity);
                for (int i = 0; i < activityCount * 100000; i++) {
                    i++;
                    i--;
                }
                try {
                    // Random sleep up to delay milliseconds
                    Thread.sleep(Math.round(Math.random() * delay * 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName() + " - STATE 3");
    }
}

