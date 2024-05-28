package main.java.app4;

public class ExecutionThread extends Thread {
    private final Integer monitor;
    private final int minActivity;
    private final int maxActivity;
    private final int delay;

    public ExecutionThread(Integer monitor, int minActivity, int maxActivity, int delay) {
        this.monitor = monitor;
        this.minActivity = minActivity;
        this.maxActivity = maxActivity;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName() + " STATE - 1");

            synchronized (monitor) {
                System.out.println(getName() + " STATE - 2");
                // Simulate activity within minActivity and maxActivity bounds
                int activityCount = (int) Math.round(Math.random() * (maxActivity - minActivity) + minActivity);
                for (int i = 0; i < activityCount * 100000; i++) {
                    i++;
                    i--;
                }
            }

            System.out.println(getName() + " STATE - 3");

            try {
                // Random sleep up to delay milliseconds
                Thread.sleep(Math.round(Math.random() * delay * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(getName() + " STATE - 4");
        }
    }
}
