package App3;

import java.util.concurrent.CountDownLatch;

class ExecutionThread2 extends Thread {
    Integer monitorP10;
    int activity_min;
    int activity_max;
    int sleep;
    ExecutionThread thread1;
    CountDownLatch latch;

    public ExecutionThread2(Integer monitorP10, int sleep, int activity_min, int activity_max, ExecutionThread thread1, CountDownLatch latch) {
        this.monitorP10 = monitorP10;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.thread1 = thread1;
        this.latch = latch;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 7");
        synchronized(this.monitorP10) {
            try {
                this.monitorP10.wait();
            } catch (InterruptedException var5) {
                throw new RuntimeException(var5);
            }

            try {
                Thread.sleep((long)(this.sleep * 500));
            } catch (InterruptedException var4) {
                throw new RuntimeException(var4);
            }

            System.out.println(this.getName() + " - STATE 8 - received token from T10");
            int k = (int)Math.round(Math.random() * (double)(this.activity_max - this.activity_min) + (double)this.activity_min);
            int i = 0;

            while(true) {
                if (i >= k * 100000) {
                    System.out.println(this.getName() + " - STATE 9");
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