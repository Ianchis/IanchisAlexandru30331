package App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Fir1 extends Thread {
    Lock l9;
    Lock l10;
    CountDownLatch latch;
    int name;
    int sleep;
    int activity_min;
    int activity_max;

    Fir1(int n, int sleep, int a_min, int a_max, Lock la, Lock lb, CountDownLatch latch) {
        this.name = n;
        this.sleep = sleep;
        this.activity_min = a_min;
        this.activity_max = a_max;
        this.latch = latch;
        this.l9 = la;
        this.l10 = lb;
    }

    public void run() {
        while(true) {
            System.out.println(this.name + " State 1");
            this.l9.lock();
            this.l10.lock();
            System.out.println(this.name + " acquired the lock" + this.l9 + " and " + this.l10);
            System.out.println(this.name + " State 2");
            int k = (int)Math.round(Math.random() * (double)(this.activity_max - this.activity_min) + (double)this.activity_min);

            for(int i = 0; i < k * 100000; ++i) {
                ++i;
                --i;
            }

            this.l9.unlock();
            this.l10.unlock();
            System.out.println(this.name + " released the lock" + this.l9 + " and " + this.l10);

            try {
                Thread.sleep((long)(this.sleep * 500));
            } catch (InterruptedException var4) {
                throw new RuntimeException(var4);
            }

            System.out.println(this.name + " State 3");
            this.latch.countDown();
            System.out.println("T8 has been reached by Fir " + this.name);

            try {
                Thread.sleep(4000L);
            } catch (InterruptedException var3) {
                throw new RuntimeException(var3);
            }
        }
    }
}
