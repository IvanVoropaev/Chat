package net.chat.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Irina on 23.05.2014.
 */
public class ClientStart {
    private Socket socket;
    private InputStream inStream;
    private OutputStream outStream;
    private Scanner inFromServer;
    private Scanner inFromCmd;

    public ClientStart() throws IOException {
        socket = new Socket("localhost", 4321);
        inStream = socket.getInputStream();
        outStream = socket.getOutputStream();
        inFromServer = new Scanner(inStream);
        inFromCmd = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }
}
