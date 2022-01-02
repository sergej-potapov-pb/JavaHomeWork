package com.pb.potapov.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static class Handler implements Runnable {
        private final Socket clientSocket;

        public Handler(Socket socket) {
            this.clientSocket = socket;
        }
        @Override
        public void run() {
            try {
                // поток для чтения данных
                BufferedReader inMsg = null;
                // поток для отправки данных
                PrintWriter outMsg = null;

                System.out.println("Подключился клиент - "+Thread.currentThread().getName());
                // создаем потоки для связи с клиентом
                inMsg = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outMsg = new PrintWriter(clientSocket.getOutputStream(), true);
                String clientMessage;
                outMsg.println("Ваше имя на сервере : "+Thread.currentThread().getName());

                // цикл ожидания сообщений от клиента
                //System.out.println("Ожидаем сообщений");
                while ((clientMessage = inMsg.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(clientMessage)) {
                        System.out.println("Отключился клиент - "+Thread.currentThread().getName());
                        break;
                    }
                    LocalDateTime today = LocalDateTime.now();
                    String msgStr =today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm"))+" ( "+Thread.currentThread().getName()+") -> " + clientMessage;
                    outMsg.println(msgStr);
                    System.out.println(msgStr);
                }

                // Закрываем все соединения c текущим клиентом
                outMsg.close();
                inMsg.close();
                clientSocket.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (Exception ex) {
                    // ignore
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Сервер запущен");
        int serverPort = 9000;


        // серверный сокет
        ServerSocket serverSocket = null;

        // создаем серверный сокет
        try {
            serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            System.out.println("Ошибка связывания с портом "+ serverPort);
            System.exit(-1);
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // В цикле ждем запроса клиента
        while (true) {
            Socket clientSocketWait = serverSocket.accept();
            threadPool.submit(new Handler(clientSocketWait));
        }
    }
}
