package main.java.app1;

public class Main {
    public static void main(String[] args) {
        Integer monitor = 1;
        // Create and start two threads with different parameters
        new ExecutionThread(monitor, 2, 4, 3, 6).start();
        new ExecutionThread(monitor, 3, 5, 4, 7).start();
    }
}

