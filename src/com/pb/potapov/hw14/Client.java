package com.pb.potapov.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    // прием сообщений от сервера
    static class AcceptMessages implements Runnable {
        // поток для чтения данных
        BufferedReader inMsg = null;

        public AcceptMessages(BufferedReader inMsg) throws IOException {
            this.inMsg = inMsg;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {

                    String dataFromServer = inMsg.readLine();
                    System.out.println(dataFromServer);

                } catch (IOException ex) {
                    // ignore
                    break;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Клиент стартовал");
        String serverIp = "127.0.0.1";
        int serverPort = 9000;
        System.out.println("Соединяемся с сервером " + serverIp + ":" + serverPort + "\n" +
                "Для завершения работы наберите - exit");

        try {
            Socket server = new Socket(serverIp, serverPort);

            BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);
            BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

            String dataFromUser;

            Thread AcceptMessagesThread = new Thread(new AcceptMessages(inServer));
            AcceptMessagesThread.start();

            // Основной цикл отправки сообщений серверу
            while ((dataFromUser = inConsole.readLine()) != null) {
                outServer.println(dataFromUser);
                if ("exit".equalsIgnoreCase(dataFromUser)) {
                    break;
                }
            }
            AcceptMessagesThread.interrupt();
            outServer.close();
            inServer.close();
            server.close();
        } catch (IOException ex) {
            System.out.println("Сервер " + serverIp + ":" + serverPort + " не отвечает");
            return;
        };
    }
}
