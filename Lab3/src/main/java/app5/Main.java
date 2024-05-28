package main.java.app5;

public class Main {
    public static void main(String[] args) {
        Object monitor1 = new Object();
        Object monitor2 = new Object();

        MainThread t1 = new MainThread(2, 3, 7, monitor1, monitor2);
        SecondaryThread t2 = new SecondaryThread(3, 5, 0, monitor1, t1);
        SecondaryThread t3 = new SecondaryThread(4, 6, 0, monitor2, t1);

        t1.start();
        t2.start();
        t3.start();

        System.out.println("FINAL STATE");
    }
}
