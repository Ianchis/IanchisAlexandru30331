package main.java.App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class ExecutionThread extends Thread {
    private final int minActivity;
    private final int maxActivity;
    private final int delay;
    private final Lock P9;
    private final CountDownLatch T8;

    public ExecutionThread(Lock P9, CountDownLatch T8, int minActivity, int maxActivity, int delay) {
        this.P9 = P9;
        this.T8 = T8;
        this.minActivity = minActivity;
        this.maxActivity = maxActivity;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.getName() + " - STATE 1");
            P9.lock();
            System.out.println(this.getName() + " - STATE 2");

            int k = (int) Math.round(Math.random() * (maxActivity - minActivity) + minActivity);
            try {
                Thread.sleep(Math.round(Math.random() * delay * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            P9.unlock();
            System.out.println(this.getName() + " - STATE 3");

            T8.countDown();
            try {
                T8.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

