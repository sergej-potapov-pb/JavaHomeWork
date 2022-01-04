package com.pb.potapov.hw13;

import java.util.LinkedList;

public class prodANDcons2 {

    static private LinkedList<String> msgQueue = new LinkedList<>();

    static class Producer implements Runnable {
        public String name;

        public void run() {
            name = Thread.currentThread().getName();

            try {

                producer();

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(name + " закончил работу");
        }

        public void producer() throws InterruptedException{
            System.out.println(name + " стартовал");

            Integer counter = 0;
            while (counter < 25) {
                synchronized (msgQueue) {
                    System.out.println(name + " цикл " + counter);
                    // наполняем очередь элементами до 5-ти штук
                    if (msgQueue.size() >= 5) {
                        // если очередь переполнена, делаем паузу
                        System.out.println(name + " заполнил очередь. Ожидание");
                        msgQueue.wait();
                    }

                    String str = "String " + (counter++);
                    msgQueue.add(str);
                    System.out.println(name + " добавил : " + str);
                    msgQueue.notifyAll();

                    // тормозим производителя
                    Thread.sleep(350);
                }
            }

        }

    }

    static class Consumer implements Runnable {
        public String name;

        public void run(){
            name = Thread.currentThread().getName();
            System.out.println(name + " стартовал");
            while (!Thread.interrupted()) {
                try {

                    consumer();

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(name + " закончил работу");
        }

        public void consumer() throws InterruptedException{

            synchronized (msgQueue) {
                System.out.println(name + "-> " + msgQueue);
                if (msgQueue.isEmpty()) {

                    msgQueue.wait();

                }

                msgQueue.notifyAll();
                System.out.println(name + " обработал : " + msgQueue.poll());

                // тормозим потребителя
                //Thread.sleep(100);
            }

        }

    }

    public static void main(String[] args) {


        Thread producer = new Thread(new Producer(), "Producer");
        Thread consumer = new Thread(new Consumer(), "Consumer");
        producer.start();
        consumer.start();

        while (producer.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        consumer.interrupt();
        System.exit(0);

    }

}
