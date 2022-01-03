package com.pb.potapov.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static class RouteMessages implements Runnable {
        private final Queue<String> msgQueue;
        LinkedList<Handler> clients = new LinkedList<>();

        public RouteMessages(Queue<String> msgQueue, LinkedList<Handler> clients) {
            this.msgQueue = msgQueue;
            this.clients = clients;
        }


        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {

                    sendAll();

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    break;
                }
            }
        }

        private void sendAll() throws InterruptedException {
            synchronized (msgQueue) {
                if (msgQueue.isEmpty()) { // Если пуста, надо ждать

                    msgQueue.wait();

                }


                if (!msgQueue.isEmpty()) {
                    String tmpStr = msgQueue.poll();
                    if (!tmpStr.isEmpty()) {
                        System.out.println(tmpStr);
                        // очистка списка от закрытых соединений
                        for (int r = 0; r < clients.size(); r++) {
                            Handler handler = (Handler) clients.get(r);
                            if (handler.getClientSocket().isClosed()) {
                                clients.remove(r);
                            }

                        }

                        // отправляем сообщения всем подключенным клиентам
                        for (int i = 0; i < clients.size(); i++) {
                            Handler handler = (Handler) clients.get(i);
                            handler.outMsg.println(tmpStr);
                        }
                        // для отладки - удалить
                        // System.out.println("clients count = " + clients.size());
                    }
                }

                msgQueue.notifyAll();

            }
        }
    }


    static class Handler implements Runnable {
        private final Socket clientSocket;
        private final Queue<String> msgQueue;
        // Максимальный размер очереди
        private final int maxSize;
        private String clientName = null;
        // поток для отправки данных
        public PrintWriter outMsg = null;

        public String getClientName() {
            return clientName;
        }

        public Handler(Socket socket, Queue<String> msgQueue, int maxSize) throws IOException {
            this.clientSocket = socket;
            this.msgQueue = msgQueue;
            this.maxSize = maxSize;
            this.outMsg = new PrintWriter(socket.getOutputStream(), true);

        }

        public Socket getClientSocket() {
            return clientSocket;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public void msgToQueue(String message) throws InterruptedException {
            synchronized (msgQueue) { // обязательно synchronized

                if (msgQueue.size() >= maxSize) {
                    // Если очередь полна, то ждём
                    msgQueue.wait();
                }

                // Добавили элемент в очередь.
                msgQueue.add(message);

                // Уведомили другой поток на случай, если он ждет
                msgQueue.notifyAll();
            }
        }

        @Override
        public void run() {
            try {
                // поток для чтения данных
                BufferedReader inMsg = null;

                System.out.println("Подключился клиент - " + Thread.currentThread().getName());

                inMsg = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String clientMessage;
                outMsg.println("Ваше имя на сервере : " + Thread.currentThread().getName());
                setClientName(Thread.currentThread().getName());

                // цикл ожидания сообщений от клиента
                while ((clientMessage = inMsg.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(clientMessage)) {
                        System.out.println("Отключился клиент - " + Thread.currentThread().getName());
                        break;
                    }
                    LocalDateTime today = LocalDateTime.now();
                    String msgStr = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) + " ( " + getClientName() + ") -> " + clientMessage;
                    msgToQueue(msgStr);
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
        LinkedList<Handler> clients = new LinkedList<>();
        LinkedList<String> msgQueue = new LinkedList<>();
        int MaxSize = 20; // размер очереди сообщений

        int serverPort = 9000;

        // серверный сокет
        ServerSocket serverSocket = null;

        // создаем серверный сокет
        try {
            serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            System.out.println("Ошибка работы с портом " + serverPort);
            System.exit(-1);
        }

        System.out.println("Сервер запущен");

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Thread RouteMessagesThread = new Thread(new RouteMessages(msgQueue, clients));
        RouteMessagesThread.start();

        // В цикле ждем запроса клиента
        while (true) {
            Socket clientSocketWait = serverSocket.accept();
            clients.add(new Handler(clientSocketWait, msgQueue, MaxSize));
            threadPool.submit(clients.getLast());
        }
    }
}
