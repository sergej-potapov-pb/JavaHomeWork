package com.pb.potapov.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int x;
        Scanner scan = new Scanner(System.in);
        System.out.println("Проверка Вашего числа на вхождение в заданный интервал");
        System.out.print("Введите число ->");
        x = scan.nextInt();
        System.out.print("\nВведенное число -> " + x );
        if ( x >=0 && x<=14)
            System.out.println(" попадает в заданный интервал [0..14]");
        else if ( x >=15 && x<=35)
            System.out.println(" попадает в заданный интервал [15..35]");
        else if ( x >=36 && x<=50)
            System.out.println(" попадает в заданный интервал [36..50]");
        else if ( x >=51 && x<=100)
            System.out.println(" попадает в заданный интервал [51..100]");
        else
            System.out.println(" не попадает в заданную группу интервалов\n[0..14]\n[15..35]\n[36..50]\n[51..100]");

    }
}
