package main.java.App3;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        Object P6 = new Object();
        Object P10 = new Object();
        CountDownLatch T11 = new CountDownLatch(3);

        ExecutionThreadMain thread1 = new ExecutionThreadMain(2, 3, 7, P6, P10, T11);
        ExecutionThreadSecondary thread2 = new ExecutionThreadSecondary(3, 5, 2, P6, T11);
        ExecutionThreadSecondary thread3 = new ExecutionThreadSecondary(3, 5, 5, P6, T11);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Transition T11 executed successfully");
    }
}

