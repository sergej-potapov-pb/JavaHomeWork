package com.pb.potapov.hw9;

import com.pb.potapov.hw7.Pants;

import java.io.BufferedReader;
import java.util.Random;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileNumbers {
    public static void main(String[] args) {
        Path fileSrc = Paths.get("numbers.txt");
        Path fileOdd = Paths.get("odd-numbers.txt");

        System.out.println("Генерация содержимого в файл \"" + fileSrc.toAbsolutePath() + "\"");

        createNumbersFile( fileSrc);

        System.out.println("Файл \"" + fileSrc.toAbsolutePath() + "\"  записан!");

        System.out.println("Чтение и обработка файла \"" + fileSrc.toAbsolutePath() + "\":");

        createOddNumbersFile( fileSrc, fileOdd);

        System.out.println("Обработка файлов завершена!");
    }

    public static void createNumbersFile(Path fpath) {
        String strOut = "";
        Random random = new Random();
        int x;
        try (BufferedWriter fwriter = Files.newBufferedWriter(fpath)) {
            // формируем 10 строк
            for (byte ss = 0; ss < 10; ss++) {
                // формируем строку из 10 элементов
                fwriter.write(String.valueOf(random.nextInt(100)));
                for (byte ii = 0; ii < 9; ii++) {
                    fwriter.write( " "+ random.nextInt(100));
                }
                fwriter.newLine();
            }
        } catch (Exception ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }

    }

    public static void createOddNumbersFile(Path pathIn, Path pathOut) {

        String line;
        String lineOut;

        try (BufferedReader inReader = Files.newBufferedReader(pathIn) ;
             BufferedWriter oddWriter = Files.newBufferedWriter(pathOut)
        ) {
            System.out.println("-  -  -  -  -  -  -  -  -  -  -  -");
            while ((line = inReader.readLine()) != null) {
                String[] linePart = line.split(" ");
                lineOut ="";
                System.out.println(line);
                for (int lp=0;lp<linePart.length;lp++){

                    if ( Integer.valueOf(linePart[lp]) % 2 ==0){
                        lineOut = lineOut+ "00 ";
                    } else {
                        lineOut = lineOut + linePart[lp]+ " ";
                    }

                }

                System.out.println(lineOut);
                System.out.println("-  -  -  -  -  -  -  -  -  -  -  -");
                oddWriter.write(lineOut);
                oddWriter.newLine();
            }


        } catch (Exception ex) {
            System.out.println("Ошибка чтения файла: " + ex);
        }

    }
}

