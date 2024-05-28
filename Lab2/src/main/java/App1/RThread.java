package main.java.App1;

public class RThread extends Thread {
    private final FileService fileService;

    public RThread(FileService fileService) {
        this.fileService = fileService;
    }

    public void run() {
        while (!Main.isStopThreads()) {
            try {
                String message = fileService.read();
                System.out.println(message);
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
