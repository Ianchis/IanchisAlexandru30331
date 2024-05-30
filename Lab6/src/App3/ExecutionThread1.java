package App3;

import java.util.concurrent.CountDownLatch;

class ExecutionThread1 extends Thread {
    Integer monitorP6;
    int activity_min;
    int activity_max;
    int sleep;
    ExecutionThread thread1;
    CountDownLatch latch;

    public ExecutionThread1(Integer monitorP6, int sleep, int activity_min, int activity_max, ExecutionThread thread1, CountDownLatch latch) {
        this.monitorP6 = monitorP6;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.thread1 = thread1;
        this.latch = latch;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 3");
        synchronized(this.monitorP6) {
            try {
                this.monitorP6.wait();
            } catch (InterruptedException var5) {
                throw new RuntimeException(var5);
            }

            try {
                Thread.sleep((long)(this.sleep * 500));
            } catch (InterruptedException var4) {
                throw new RuntimeException(var4);
            }

            System.out.println(this.getName() + " - STATE 4 - received token from T6");
            int k = (int)Math.round(Math.random() * (double)(this.activity_max - this.activity_min) + (double)this.activity_min);
            int i = 0;

            while(true) {
                if (i >= k * 100000) {
                    System.out.println(this.getName() + " - STATE 5");
                    break;
                }

                ++i;
                --i;
                ++i;
            }
        }

        this.latch.countDown();
    }
}
