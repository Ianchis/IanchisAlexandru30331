package main.java.App3;

import java.util.concurrent.CountDownLatch;

public class ExecutionThreadMain extends Thread {
    private final int delay;
    private final int minActivity;
    private final int maxActivity;
    private final Object P9;
    private final Object P10;
    private final CountDownLatch T11;

    public ExecutionThreadMain(int minActivity, int maxActivity, int delay, Object P9, Object P10, CountDownLatch T11) {
        this.delay = delay;
        this.minActivity = minActivity;
        this.maxActivity = maxActivity;
        this.P9 = P9;
        this.P10 = P10;
        this.T11 = T11;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        try {
            Thread.sleep(Math.round(Math.random() * delay * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (maxActivity - minActivity) + minActivity);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        synchronized (P9) {
            P9.notifyAll();
        }
        synchronized (P10) {
            P10.notifyAll();
        }
        System.out.println(this.getName() + " - STATE 3");
        T11.countDown();
        try {
            T11.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

