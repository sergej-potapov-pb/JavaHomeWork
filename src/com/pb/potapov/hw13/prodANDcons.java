package com.pb.potapov.hw13;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class prodANDcons {

    static private Queue<String> msgQueue = new ConcurrentLinkedQueue<String>();

    static class Producer implements Runnable {

        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + " стартовал");

            Integer counter = 0;

            try {
                do{
                    System.out.println(name + " цикл "+counter);
                    // наполняем очередь элементами до 5-ти штук
                    if(msgQueue.size()<5) {
                        String str = "String " + (counter++);
                        msgQueue.add(str);
                        System.out.println(name + " добавил : " + str);
                        Thread.sleep(200);
                    } else{
                        // если очередь переполнена, делаем паузу
                        System.out.println(name + " заполнил очередь. Ожидание");
                    }
                } while(counter<25);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(name + " закончил работу");
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            String str;
            String name = Thread.currentThread().getName();
            System.out.println(name + " стартовал");

            do{
                System.out.println(name + "-> "+msgQueue);
                if ((str = msgQueue.poll()) != null){
                    System.out.println(name + " обработал : " + str);
                }
                try {
                    Thread.sleep(245);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } while (msgQueue.size() > 0);
            System.out.println(name + " закончил работу");
        }
    }

    public static void main(String[] args) {


        Thread producer = new Thread(new Producer(), "Producer");
        Thread consumer = new Thread(new Consumer(), "Consumer");
        producer.start();
        consumer.start();

        while (consumer.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);

    }

}
