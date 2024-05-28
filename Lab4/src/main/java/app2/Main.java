package main.java.app2;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4); // Semaphore with 4 permits

        // Create threads with random activity counts within specified range
        Fir f1 = new Fir(1, semaphore, 2, (int) Math.round(Math.random() * 3 + 2), 2);
        Fir f2 = new Fir(2, semaphore, 4, (int) Math.round(Math.random() * 3 + 3), 2);

        f1.start(); // Start thread f1
        f2.start(); // Start thread f2
    }
}

