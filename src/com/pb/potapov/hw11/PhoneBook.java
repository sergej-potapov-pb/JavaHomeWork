package com.pb.potapov.hw11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class PhoneBook {

    public static ArrayList<PhoneBookItem> pbArray = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nТелефонная книга\nВыберите операцию\n");
            System.out.println("1. Добавить элемент");
            System.out.println("2. Удалить элемент");
            System.out.println("3. Редактировать элемент");
            System.out.println("4. Поиск элемента");
            System.out.println("5. Показать всю телефонную книгу");
            System.out.println("6. Записать в файл");
            System.out.println("7. Загрузить из файла");
            System.out.println("0. Выход");

            String option = scan.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Добавляем элемент");
                    addPBitem();
                    break;
                case "2":
                    System.out.println("Удаляем элемент");
                    delPBitem();
                    break;
                case "3":
                    System.out.println("Редактируем элемент");
                    editPBitem();
                    break;
                case "4":
                    System.out.println("Поиск элемента");
                    break;
                case "5":
                    System.out.println("Показать всю телефонную книгу");
                    listPBarray();
                    break;
                case "6":
                    System.out.println("Записать в файл");
                    break;
                case "7":
                    System.out.println("Загрузить из файла");
                    break;
                case "0":
                    System.out.println("Завершение работы");
                    return;
                default:
                    System.out.println("Wrong menu number!");
            }
        }
    }

    public static void editPBitem() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер один из "+pbArray.size()+"-> ");
        while (true) {
            Integer i = scan.nextInt();
            scan.nextLine();
            if ((i == null) || (i == 0) || (i > pbArray.size())) {
                System.out.println("Неверно задан номер записи для удаления\nНачните операцию заново.");
                break;
            } else {
                System.out.println("Редактирование записи № " + i);
                //String inName = scan.nextLine();

                System.out.print("ФИО ( " + pbArray.get(i - 1).getName() + " ) -> ");
                String inName = scan.nextLine();
                if (!inName.isEmpty()) {
                    pbArray.get(i - 1).setName(inName);
                    System.out.println(pbArray.get(i - 1).getName());
                }

                System.out.print("Дата рождения ( " + pbArray.get(i - 1).getbDay() + " ) -> ");
                String inBDay = scan.nextLine();
                if (!inBDay.isEmpty()) {
                    pbArray.get(i - 1).setbDay(inBDay);
                    System.out.println(pbArray.get(i - 1).getbDay());
                }
                System.out.print("Адрес ( " + pbArray.get(i - 1).getAddress() + " ) -> ");
                String inAddress = scan.nextLine();
                if (!inAddress.isEmpty()) {
                    pbArray.get(i - 1).setAddress(inAddress);
                    System.out.println(pbArray.get(i - 1).getAddress());
                }


                break;
            }
        }

    }

    public static void delPBitem() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер -> ");
        while (true) {
            Integer i = scan.nextInt();
            if ((i == null) || (i == 0) || (i > pbArray.size())) {
                System.out.println("Неверно задан номер записи для удаления\nНачните операцию заново.");
                break;
            } else {
                pbArray.remove(i - 1);
                break;
            }

        }


    }

    public static void addPBitem() {
        Scanner scan = new Scanner(System.in);
        LinkedList<String> inPhoneNumbers = new LinkedList<>();

        // ввод данных ФИО, день рождения, адрес
        System.out.print("Новая запись в книге\nВведите ФИО -> ");
        String inName = scan.nextLine();
        System.out.print("Дата рождения -> ");
        String inBDay = scan.nextLine();
        System.out.print("Адрес -> ");
        String inAddress = scan.nextLine();

        PhoneBookItem pbItem = new PhoneBookItem(inName, inBDay, inAddress);

        // добавляем номера
        System.out.print("\nДобавьте номера телефона. Enter - выход.\n+380xxxxxxxxx -> ");
        while (true) {
            String inNumber = scan.nextLine();
            if (inNumber.isEmpty()) {
                // пустой ввод - конец ввода номеров
                break;

            } else {
                // проверяем набор введенных символов, длинна от 5 до 13
                if (inNumber.matches("[+0-9]{5,13}")) {
                    inPhoneNumbers.add(inNumber);
                } else {
                    // повторяем ввод номера
                    System.out.println("Ошибка формата. Повторите ввод.");

                }
                System.out.print("\n+380xxxxxxxxx -> ");
            }

        }

        if (!inPhoneNumbers.isEmpty()) {
            // если список номеров не пустой, сохраняем его в записи, и сохраняем всю запись в книгу
            pbItem.setPhoneNumbers(inPhoneNumbers);
            pbArray.add(pbItem);
            System.out.println("Ввод номеров окончен");

        } else {
            System.out.println("Вы не задали ни одного номера телефона. Начните добавление заново.");

        }
    }

    public static void listPBarray() {
        if (pbArray.isEmpty()) {
            System.out.println("Книга пуста.");
        } else {
            for (int i = 0; i < pbArray.size(); i++) {
                System.out.println((i + 1) + ". " + pbArray.get(i).toString());
            }
        }
    }
}
