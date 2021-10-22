package com.pb.potapov.hw3;

import java.util.Scanner;

public class Bubble_sort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);      // ввод данных пользователя
        int[] BubArray = new int[10];               // массив пользователя для сортировки
        int SizeA = BubArray.length;                // размер массива
        long SumA=0;                                // сумма элементов массива
        int b=0;                                    // число положительных элементов

        System.out.println("Программа для обработки чисел в массиве из 10 элементов.");
        System.out.println("Необходимо заполнить массив\n");

        // Заполнение элементов массива
        for (int i = 0; i < SizeA; i++) {
            System.out.print("[" + (i+1) +"] = ");
            BubArray[i] = scan.nextInt();
        }

        // Вывод на экран значений элементов массива
        System.out.println("Вы ввели следующие числа в массив:");
        for ( int i = 0; i < SizeA; i++) {
            System.out.print("  "+ BubArray[i]);
        }
        // Сумма всех значений элементов массива
        System.out.print("\nСумма всех значений элементов массива: ");
        for ( int i = 0; i < SizeA; i++) {
            SumA = SumA + BubArray[i];
        }
        System.out.println(SumA);

        // Количество положительных элементов массива
        System.out.print("Количество положительных элементов массива: ");
        for ( int i = 0; i < SizeA; i++) {
            if (BubArray[i]>0) {
               b++;
            }
        }
        System.out.println(b);

//        ЦИКЛ ДЛЯ J=1 ДО N-1 ШАГ 1                       FOR J=1 TO N-1 STEP 1
//        F=0                                             F=0
//        ЦИКЛ ДЛЯ I=0 ДО N-1-J ШАГ 1                     FOR I=0 TO N-1-J STEP 1
//        ЕСЛИ A[I] > A[I+1] ТО ОБМЕН A[I],A[I+1]:F=1     IF A[I]>A[I+1] THEN SWAP A[I],A[I+1]:F=1
//        СЛЕДУЮЩЕЕ I                                     NEXT I
//        ЕСЛИ F=0 ТО ВЫХОД ИЗ ЦИКЛА                      IF F=0 THEN EXIT FOR
//        СЛЕДУЮЩЕЕ J                                     NEXT J


        // Сортировка "пузырьковым" методом
        int s;                                          // переменная для обмена
        boolean e;                                      // флаг прерывания итерации
        for (int i = 0; i < SizeA-1; i++) {
            e=false;
            for(int j=0; j < SizeA-1-i; j++){
                if( BubArray[j]> BubArray[j+1] ) {
                    s = BubArray[j+1];
                    BubArray[j+1] = BubArray[j];
                    BubArray[j] = s;
                    e=true;
                }
            }
            if (!e) {
                break;
            }
        }
        // Вывод на экран значений элементов массива
        System.out.println("\nРезультат сортировки \"пузырьковым\" методом :");
        for (int i = 0; i < SizeA; i++) {
            System.out.print("  "+ BubArray[i]);
        }
    }
}
