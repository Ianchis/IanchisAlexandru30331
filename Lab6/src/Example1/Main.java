package Example1;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            public void run() {
                System.out.println("Barrier Routine");
            }
        });
        Fir fir1 = new Fir(barrier);
        Fir fir2 = new Fir(barrier);
        Fir fir3 = new Fir(barrier);
        fir1.start();
        fir2.start();
        fir3.start();
    }
}
