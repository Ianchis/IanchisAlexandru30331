package App3;

import java.util.concurrent.CountDownLatch;

class ExecutionThread extends Thread {
    Integer monitorP6;
    Integer monitorP10;
    CountDownLatch latch;
    int sleep;
    int activity_min;
    int activity_max;

    public ExecutionThread(Integer monitorP6, Integer monitorP10, int sleep, int activity_min, int activity_max, CountDownLatch latch) {
        this.monitorP6 = monitorP6;
        this.monitorP10 = monitorP10;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.latch = latch;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 0");

        try {
            Thread.sleep((long)(this.sleep * 500));
        } catch (InterruptedException var5) {
            throw new RuntimeException(var5);
        }

        System.out.println(this.getName() + " - STATE 1");
        int k = (int)Math.round(Math.random() * (double)(this.activity_max - this.activity_min) + (double)this.activity_min);

        for(int i = 0; i < k * 100000; ++i) {
            ++i;
            --i;
        }

        synchronized(this.monitorP6) {
            System.out.println(this.getName() + " - STATE 2 - gives token to P6");
            this.monitorP6.notify();
        }

        synchronized(this.monitorP10) {
            System.out.println(this.getName() + " - STATE 3 - gives token to P10");
            this.monitorP10.notify();
        }

        this.latch.countDown();
    }
}
