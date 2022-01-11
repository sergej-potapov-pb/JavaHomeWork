package com.pb.potapov.hw15;

import java.io.*;
import java.net.Socket;

public class MiniChatConnection {
    private final Socket server;
    private final BufferedReader inServer;
    private final BufferedWriter outServer;
    private final Thread AcceptMessagesThread;
    private final MiniChatEvent mcEvent;

    public MiniChatConnection(Socket server, MiniChatEvent mcEvent) throws IOException {
        this.server = server;
        this.mcEvent = mcEvent;
        inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        outServer = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));

        AcceptMessagesThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mcEvent.onConnectionReady(MiniChatConnection.this);
                    while (!AcceptMessagesThread.isInterrupted()) {
                        String msg = inServer.readLine();
                        mcEvent.onReceiveString(MiniChatConnection.this, msg);
                    }

                } catch (IOException ex) {
                    mcEvent.onException(MiniChatConnection.this, ex);

                } finally {
                    mcEvent.onDisconnect(MiniChatConnection.this);

                }
            }
        }
        );
        AcceptMessagesThread.start();
    }

    public synchronized void sendMessage(String msg) {
        try {
            outServer.write(msg+"\n");
            outServer.flush();
        } catch (IOException ex) {
            mcEvent.onException(MiniChatConnection.this, ex);
            diconnect();
        }
    }

    public synchronized void diconnect() {
        AcceptMessagesThread.interrupt();
        try {
            outServer.close();
            inServer.close();
            server.close();
        } catch (IOException ex) {
            mcEvent.onException(MiniChatConnection.this, ex);
        }
    }
}
