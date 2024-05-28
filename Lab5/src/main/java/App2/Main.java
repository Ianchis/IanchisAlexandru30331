package main.java.App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock P9 = new ReentrantLock();
        Lock P10 = new ReentrantLock();
        CountDownLatch T8 = new CountDownLatch(3);

        ExecutionThread thread1 = new ExecutionThread(P9, T8, 2, 4, 4);
        ExecutionThread thread3 = new ExecutionThread(P10, T8, 2, 5, 5);
        ExecutionThreadMiddle thread2 = new ExecutionThreadMiddle(P9, P10, T8, 3, 6, 3);

        System.out.println("P0");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

