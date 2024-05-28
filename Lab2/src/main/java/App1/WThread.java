package main.java.App1;

public class WThread extends Thread {
    private final FileService fileService;

    public WThread(FileService fileService) {
        this.fileService = fileService;
    }

    public void run() {
        while (!Main.isStopThreads()) {
            String message = String.valueOf(Math.round(Math.random() * 100));
            fileService.write(message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
