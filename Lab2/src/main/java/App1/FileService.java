package main.java.App1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FileService {
    private final String fileName;
    private BufferedReader reader;
    private PrintWriter writer;

    public FileService(String fileName) {
        this.fileName = fileName;
        initializeStreams();
    }

    private void initializeStreams() {
        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
            reader = new BufferedReader(new FileReader(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void write(String message) {
        writer.println("Date: " + new Date());
        writer.println("Message: " + message);
        writer.flush();
    }

    public synchronized String read() throws IOException {
        String line, lastMessage = "no message to read";
        while ((line = reader.readLine()) != null) {
            lastMessage = new Date() + " - " + line;
        }
        return lastMessage;
    }
}
