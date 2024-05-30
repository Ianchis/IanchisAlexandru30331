package App1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Semaphore s9 = new Semaphore(1);
        Semaphore s10 = new Semaphore(1);
        CyclicBarrier barrier = new CyclicBarrier(2);
        Fir f1 = new Fir(1, s9, s10, barrier, 4, 1, 2, 4, 4, 6);
        Fir f2 = new Fir(2, s9, s10, barrier, 5, 1, 3, 5, 5, 7);
        f1.start();
        f2.start();
    }
}