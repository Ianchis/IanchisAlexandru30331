package main.java.App1;

public class Main {
    private static volatile boolean stopThreads = false;

    public static void main(String[] args) {
        FileService fileService = new FileService("messages.txt");
        Thread readerThread = new RThread(fileService);
        Thread writerThread = new WThread(fileService);

        readerThread.start();
        writerThread.start();
    }

    public static boolean isStopThreads() {
        return stopThreads;
    }
}
