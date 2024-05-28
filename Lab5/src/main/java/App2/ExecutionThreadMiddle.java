package main.java.App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class ExecutionThreadMiddle extends Thread {
    private final int minActivity;
    private final int maxActivity;
    private final int delay;
    private final Lock P9;
    private final Lock P10;
    private final CountDownLatch T8;

    public ExecutionThreadMiddle(Lock P9, Lock P10, CountDownLatch T8, int minActivity, int maxActivity, int delay) {
        this.P9 = P9;
        this.P10 = P10;
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
            P10.lock();
            System.out.println(this.getName() + " - STATE 2");

            int k = (int) Math.round(Math.random() * (maxActivity - minActivity) + minActivity);
            try {
                Thread.sleep(Math.round(Math.random() * delay * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            P9.unlock();
            P10.unlock();
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

