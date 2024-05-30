package Example1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Fir extends Thread {
    CyclicBarrier bariera;

    public Fir(CyclicBarrier bariera) {
        this.bariera = bariera;
    }

    public void run() {
        while(true) {
            this.activitate();

            try {
                this.bariera.await();
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            } catch (BrokenBarrierException var3) {
                var3.printStackTrace();
            }

            this.activitate();
        }
    }

    public void activitate() {
        System.out.println(this.getName() + "> activitate");

        try {
            Thread.sleep(Math.round(Math.random() * 3.0 + 3.0) * 1000L);
        } catch (InterruptedException var2) {
        }

    }
}
