package net.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;

    public Server() throws IOException {
        serverSocket = new ServerSocket(4321);
        while(true) {
            System.out.println("Wating for a client...");
            socket = serverSocket.accept();
            System.out.println("Client connected.");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    InputStream inStream;
                    OutputStream outStream;
                    PrintWriter out = null;
                    Scanner in = null;
                    try {
                        inStream = socket.getInputStream();
                        outStream = socket.getOutputStream();
                        out = new PrintWriter(outStream, true);
                        in = new Scanner(inStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    out.println("Hello! BYE to exit.");
                    boolean bye = false;
                    while (!bye && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if(line.trim().equals("BYE"))
                            bye = true;
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        new Server();
    }
}
