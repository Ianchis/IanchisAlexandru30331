package main.java.Example4;

class ThreadEx extends Thread {
    private volatile boolean stop;

    ThreadEx(ThreadGroup group, String name) {
        super(group, name);
        stop = false;
    }

    @Override
    public void run() {
        System.out.println(getName() + " ON.");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(".");
                Thread.sleep(250);
                if (shouldStop()) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
        System.out.println(getName() + " The end.");
    }

    private synchronized boolean shouldStop() {
        return stop;
    }

    public synchronized void stopThread() {
        stop = true;
    }
}

public class ThreadGroupDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("Group of threads");
        ThreadEx thread1 = new ThreadEx(group, "ThreadEx #1");
        ThreadEx thread2 = new ThreadEx(group, "ThreadEx #2");
        ThreadEx thread3 = new ThreadEx(group, "ThreadEx #3");

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000);
        System.out.println(group.activeCount() + " Threads in group.");

        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        for (Thread t : threads) {
            System.out.println(t.getName());
        }

        thread1.stopThread();
        Thread.sleep(1000);
        System.out.println(group.activeCount() + " Threads in group.");

        group.interrupt();
    }
}

