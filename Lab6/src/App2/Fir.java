package App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Fir extends Thread {
    Lock l;
    CountDownLatch latch;
    int name;
    int sleep;
    int activity_min;
    int activity_max;

    public Fir(int n, int sleep, int a_min, int a_max, Lock la, CountDownLatch latch) {
        this.name = n;
        this.sleep = sleep;
        this.activity_min = a_min;
        this.l = la;
        this.latch = latch;
    }

    public void run() {
        while(true) {
            System.out.println(this.name + "- State 1");
            this.l.lock();
            System.out.println(this.name + "- acquired the lock " + this.l);
            System.out.println(this.name + "- State 2");
            int k = (int)Math.round(Math.random() * (double)(this.activity_max - this.activity_min) + (double)this.activity_min);

            for(int i = 0; i < k * 100000; ++i) {
                ++i;
                --i;
            }

            this.l.unlock();
            System.out.println(this.name + "- released the lock " + this.l);

            try {
                Thread.sleep((long)(this.sleep * 500));
            } catch (InterruptedException var4) {
                throw new RuntimeException(var4);
            }

            System.out.println(this.name + "- acquired the lock " + this.l);
            this.latch.countDown();
            System.out.println("T8 has been reached by " + this.name);

            try {
                Thread.sleep(4000L);
            } catch (InterruptedException var3) {
                throw new RuntimeException(var3);
            }
        }
    }
}