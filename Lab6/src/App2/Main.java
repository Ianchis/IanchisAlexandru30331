package App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Lock l9 = new ReentrantLock();
        Lock l10 = new ReentrantLock();
        CountDownLatch latch = new CountDownLatch(3);
        Fir f1 = new Fir(1, 4, 2, 4, l9, latch);
        Fir1 f2 = new Fir1(2, 3, 3, 6, l9, l10, latch);
        Fir f3 = new Fir(3, 5, 2, 5, l10, latch);
        f1.start();
        f2.start();
        f3.start();

        try {
            latch.await();
        } catch (InterruptedException var8) {
            var8.printStackTrace();
        }

        System.out.println("All threads have completed their tasks.");
    }
}