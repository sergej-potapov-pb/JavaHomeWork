package com.pb.potapov.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int a, b;
        int res = 0;
        String sign;
        Scanner scan = new Scanner(System.in);

        System.out.println("Каркулятор\nВычисление арифметических функций : + - * /\nМежду двумя целыми числами\n");
        System.out.print("Введите первое число ->");
        a = scan.nextInt();
        System.out.print("Введите второе число ->");
        b = scan.nextInt();
        System.out.println("Задайте операцию ->  + - * /");
        sign = scan.next();

        switch (sign) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                if (b != 0) {
                    res = a / b;
                } else
                    System.out.println("Ошибка!\nВы задали деление на 0");
                break;
            default:
                System.out.println("Ошибка!\nВы ошиблись в выборе операции\nДопустимы ->  + - * /");
        }
        System.out.println("Ответ -> " + (res));
    }

}
