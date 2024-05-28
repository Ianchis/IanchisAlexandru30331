package main.java.Ex2;

public class Main {
    public static void main(String[] args) {
        JoinTestThread thread1 = new JoinTestThread("Thread1", null);
        JoinTestThread thread2 = new JoinTestThread("Thread2", thread1);

        thread1.start();
        thread2.start();
    }
}

