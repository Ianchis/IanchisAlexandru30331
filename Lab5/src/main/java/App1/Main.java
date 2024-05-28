package main.java.App1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        // Initialize semaphores and cyclic barrier
        Semaphore P9 = new Semaphore(1);
        Semaphore P10 = new Semaphore(1);
        CyclicBarrier T8 = new CyclicBarrier(2);

        // Create and start ExecutionThread instances
        ExecutionThread thread1 = new ExecutionThread(P9, P10, T8, 2, 4, 4, 6, 4);
        ExecutionThread thread2 = new ExecutionThread(P9, P10, T8, 3, 5, 5, 6, 5);

        System.out.println("P0");

        thread1.start();
        thread2.start();
    }
}

