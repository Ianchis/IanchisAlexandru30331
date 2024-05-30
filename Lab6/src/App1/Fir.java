package App1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir extends Thread {
    Semaphore s9;
    Semaphore s10;
    CyclicBarrier barrier;
    int name;
    int activity_min;
    int activity_max;
    int activity_min1;
    int activity_max1;
    int delay;
    int permit;

    Fir(int n, Semaphore s9, Semaphore s10, CyclicBarrier barrier, int delay, int permit, int a_min, int a_max, int a_min1, int a_max1) {
        this.name = n;
        this.s9 = s9;
        this.s10 = s10;
        this.barrier = barrier;
        this.delay = delay;
        this.permit = permit;
        this.activity_min = a_min;
        this.activity_max = a_max;
        this.activity_min1 = a_min1;
        this.activity_max1 = a_max1;
    }

    public void run() {
        while(true) {
            try {
                System.out.println(this.name + "- State 1");
                int k = (int)Math.round(Math.random() * (double)(this.activity_max - this.activity_min) + (double)this.activity_min);

                int i;
                for(i = 0; i < k * 100000; ++i) {
                    ++i;
                    --i;
                }

                this.s9.acquire(this.permit);
                System.out.println(this.name + "- Aquired a token from Semaphore 9");
                System.out.println(this.name + "- State 2");
                k = (int)Math.round(Math.random() * (double)(this.activity_max1 - this.activity_min1) + (double)this.activity_min1);

                for(i = 0; i < k * 100000; ++i) {
                    ++i;
                    --i;
                }

                this.s10.acquire(this.permit);
                System.out.println(this.name + "- Aquired a token from Semaphore 10");
                System.out.println(this.name + "- State 3");
                this.s9.release();
                System.out.println(this.name + "- Released Semaphore 9");
                this.s10.release();
                System.out.println(this.name + "- Released Semaphore 10");
                Thread.sleep((long)(this.delay * 500));
                System.out.println(this.name + "- State 4");
                this.barrier.await();
                System.out.println("T8 was reached by Fir " + this.name);
                Thread.sleep(4000L);
            } catch (InterruptedException var3) {
                var3.printStackTrace();
            } catch (BrokenBarrierException var4) {
                throw new RuntimeException(var4);
            }
        }
    }
}
