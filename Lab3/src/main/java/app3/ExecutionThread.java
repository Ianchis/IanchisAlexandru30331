package main.java.app3;

public class ExecutionThread extends Thread {
    private final Integer monitor1;
    private final Integer monitor2;
    private final int minActivity1;
    private final int maxActivity1;
    private final int minActivity2;
    private final int maxActivity2;
    private final int delay;

    public ExecutionThread(Integer monitor1, Integer monitor2, int minActivity1, int maxActivity1, int minActivity2, int maxActivity2, int delay) {
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
        System.out.println(getName() + " STATE - 1");

        // Simulate activity for monitor1
        int activity1 = (int) Math.round(Math.random() * (maxActivity1 - minActivity1) + minActivity1);
        for (int i = 0; i < activity1 * 100000; i++) {
            i++;
            i--;
        }

        synchronized (monitor1) {
            System.out.println(getName() + " STATE - 2");
            // Simulate activity for monitor2
            int activity2 = (int) Math.round(Math.random() * (maxActivity2 - minActivity2) + minActivity2);
            for (int i = 0; i < activity2 * 100000; i++) {
                i++;
                i--;
            }
        }

        synchronized (monitor2) {
            System.out.println(getName() + " STATE - 3");
            try {
                // Random sleep up to delay milliseconds
                Thread.sleep(Math.round(Math.random() * delay * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(getName() + " STATE - 4");
    }
}

