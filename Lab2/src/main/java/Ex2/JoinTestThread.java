package main.java.Ex2;

public class JoinTestThread extends Thread {
    public static int sum = 0;
    private final Thread previousThread;
    private final int number = 60000;
    private int localSum = 0;

    public JoinTestThread(String name, Thread previousThread) {
        super(name);
        this.previousThread = previousThread;
    }

    @Override
    public void run() {
        System.out.println("Thread " + getName() + " has entered the run() method");
        try {
            if (previousThread != null) {
                previousThread.join();
            }
            System.out.println("Thread " + getName() + " executing operation.");
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    localSum += i;
                }
            }
            updateGlobalSum();
            System.out.println("Thread " + getName() + " has terminated operation, with value: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void updateGlobalSum() {
        sum += localSum;
    }
}

