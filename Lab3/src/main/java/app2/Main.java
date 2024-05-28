package main.java.app2;

public class Main {
    public static void main(String[] args) {
        Integer monitor1 = 1;
        Integer monitor2 = 2;

        // Start threads with different parameters
        new ExecutionThread(monitor1, 2, 4, 4).start();
        new ExecutionThread(monitor2, 2, 5, 5).start();
        new ExecutionThreadSpecial(monitor1, monitor2, 3, 6, 3).start();
    }
}

