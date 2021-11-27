package com.pb.potapov.hw10;


import java.util.Random;

public class Main {

    public static void main(String[] args) throws BadSize {

        Random random = new Random();
        int x;
        NumBox<Number> NumBoxs = new NumBox<>(5);
        NumBox<Number> NumBoxsF = new NumBox<>(7);

        System.out.println("Формируем массив чисел int");
        // заполняем массив NumBoxs, остановка по исключению превышен размер массива
        while (true) {
            try {
                NumBoxs.add(random.nextInt(100));
            } catch (Exception ex) {
                System.out.println(ex);
                break;
            }
        }

        // показать массив чисел
        for (int i=0; i<NumBoxs.length(); i++){

            System.out.println(NumBoxs.get(i).intValue());
        }
        System.out.println("Сумма всех элементов sum() = " + NumBoxs.sum());
        System.out.println("Среднее арифметическое average() = " + NumBoxs.average());
        System.out.println("Максимальное число max() = "+NumBoxs.max().intValue());



        System.out.println("\nФормируем массив чисел float");
        while (true) {
            try {
                NumBoxsF.add(random.nextFloat());
            } catch (Exception ex) {
                System.out.println(ex);
                break;
            }
        }
        // показать массив чисел
        for (int i=0; i<NumBoxsF.length(); i++){

            System.out.println(NumBoxsF.get(i).floatValue());
        }
        System.out.println("Сумма всех элементов sum() = " + NumBoxsF.sum());
        System.out.println("Среднее арифметическое average() = " + NumBoxsF.average());
        System.out.println("Максимальное число max() = "+NumBoxsF.max().floatValue());

    }

}
