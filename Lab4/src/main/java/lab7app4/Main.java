package main.java.lab7app4;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        // Create a semaphore with 2 permits
        Semaphore semaphore = new Semaphore(2);

        // Create and start ExecutionThread instances
        new ExecutionThread(3, 6, 5, semaphore).start();
        new ExecutionThread(5, 7, 6, semaphore).start();
        new ExecutionThread(4, 7, 3, semaphore).start();
    }
}

