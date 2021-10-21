package com.pb.potapov.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {

        Random random = new Random();
        int x = random.nextInt(101);          // случайное число, которое нужно угадать
        Scanner scan = new Scanner(System.in);      // ввод данных пользователя
        int attempt = 0;                            // количество попыток
        int a;                                      // число пользователя
        String ans;                                 // ответ пользователя для продолжения
        String continueGame = "Y";                  // символ продолжения игры

        System.out.print("Игра Bingo\n\nПрограмма загадала число в диапазоне [0..100].\n\n" +
                "Чтобы отгадать, введите целое число.\nЕсли вы не угадали, программа подскажет" +
                " больше или меньше Ваше число.\n\nНачинаем\n\nВведите Ваше число ->");

        while (true) {
            a = scan.nextInt();
            attempt++;

            if (a < 0 || a > 100) {
                System.out.print("Введенное число " + a + " вне дипазона [0..100]\n\nПовторите ввод Вашего числа ->");
            } else {
                if (a == x) {
                    System.out.println("\nBINGO!\n\nВы отгадали число " + x);
                    break;
                } else {
                    if (a < x) {
                        System.out.println("Ваше число меньше.");
                    } else {
                        System.out.println("Ваше число больше.");
                    }
                    System.out.println("Для продолжения нажмите y или Y.");

                    ans = scan.next();
                    if (ans.compareToIgnoreCase(continueGame) == 0) {
                        System.out.print("Продолжаем.\n\nВведите Ваше число ->");
                    } else break;
                }
            }
        }

        System.out.println("Вы использовали " + attempt + " попыток.\n\nИгра завершена!");
    }


}


