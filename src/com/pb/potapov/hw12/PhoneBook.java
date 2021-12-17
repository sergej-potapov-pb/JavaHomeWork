package com.pb.potapov.hw12;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PhoneBook {

    public static ArrayList<PhoneBookItem> pbArray = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nТелефонная книга\nВыберите операцию\n");
            System.out.println("1. Добавить абонента");
            System.out.println("2. Удалить абонента");
            System.out.println("3. Редактировать абонента");
            System.out.println("4. Поиск абонента");
            System.out.println("5. Показать всю телефонную книгу");
            System.out.println("6. Записать в файл");
            System.out.println("7. Загрузить из файла");
            System.out.println("0. Выход");
            System.out.print("-> ");

            String option = scan.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Добавляем абонента");
                    addPBitem();
                    break;
                case "2":
                    System.out.println("Удаляем абонента");
                    delPBitem();
                    break;
                case "3":
                    System.out.println("Редактируем абонента");
                    editPBitem();
                    break;
                case "4":
                    System.out.println("Поиск абонента");
                    findPBitem();
                    break;
                case "5":
                    System.out.println("Показать всю телефонную книгу");
                    listPBarray();
                    break;
                case "6":
                    System.out.println("Записать в файл");
                    savePBitem();
                    break;
                case "7":
                    System.out.println("Загрузить из файла");
                    readPBitem(pbArray);
                    break;
                case "0":
                    System.out.println("Завершение работы");
                    return;
                default:
                    System.out.println("Выбран не верный пункт меню!");
            }
        }
    }

    public static void findPBitem() {
        if (pbArray.isEmpty()) {
            System.out.println("Книга пуста. Операция завершена.");

        } else {
            Scanner scan = new Scanner(System.in);

            while (true) {

                System.out.print("Выберите номер поля для поиска.\n1. ФИО\n2. Адрес\n3. Телефон\n0. Завершить\n-> ");
                String option = scan.nextLine();

                switch (option) {
                    case "1":
                        System.out.print("Поиск по полю ФИО -> ");
                        String findFIO = scan.nextLine();

                        for (PhoneBookItem abonent : pbArray) {
                            if (abonent.getName().toLowerCase().contains(findFIO.toLowerCase())) {
                                System.out.println(abonent.toString());
                            }
                        }
                        break;
                    case "2":
                        System.out.print("Поиск по полю Адрес -> ");
                        String findAdress = scan.nextLine();

                        for (PhoneBookItem abonent : pbArray) {
                            if (abonent.getAddress().toLowerCase().contains(findAdress.toLowerCase())) {
                                System.out.println(abonent.toString());
                            }
                        }
                        break;
                    case "3":
                        System.out.print("Поиск по полю номер телефона -> ");
                        String findPhoneNum = scan.nextLine();

                        for (PhoneBookItem abonent : pbArray) {
                            if (abonent.phoneNumbers.contains(findPhoneNum)) {
                                System.out.println(abonent.toString());
                            }
                        }
                        break;

                    case "0":
                        return;

                }

            }
        }

    }

    public static void readPBitem(ArrayList pbArrayList1) throws IOException {
        ArrayList<PhoneBookItem> pbArrayList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        try {
            pbArray = mapper.readValue(new File("phonebook12.json"), new TypeReference<ArrayList<PhoneBookItem>>() {});
        } catch (Exception ex) {
            System.out.println("Ошибка чтения файла: " + ex);
        }

    }

    public static void savePBitem() throws IOException {
        if (pbArray.isEmpty()) {
            System.out.println("Книга пуста. Операция завершена.");

        } else {
            ObjectMapper mapper = new ObjectMapper();
            // для работы с полями типа LocalDate
            SimpleModule module = new SimpleModule();
            module.addSerializer(LocalDate.class, new LocalDateSerializer());
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
            mapper.registerModule(module);

            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            try {
                mapper.writeValue(new File("phonebook12.json"), pbArray);
            } catch (Exception ex) {
                System.out.println("Ошибка записи в файл: " + ex);
            }
        }
    }

    public static void editPBitem() {
        if (pbArray.isEmpty()) {
            System.out.println("Книга пуста. Операция завершена.");

        } else {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите номер один из " + pbArray.size() + "-> ");
            while (true) {
                Integer i = scan.nextInt();
                scan.nextLine();
                if ((i == null) || (i == 0) || (i > pbArray.size())) {
                    System.out.println("Неверно задан номер записи для удаления\nНачните операцию заново.");
                    break;
                } else {
                    System.out.println("Редактирование записи № " + i + "\n ввод Enter не изменяет значение поля.");

                    System.out.print("ФИО ( " + pbArray.get(i - 1).getName() + " ) -> ");
                    String inName = scan.nextLine();
                    if (!inName.isEmpty()) {
                        pbArray.get(i - 1).setName(inName);
                        System.out.println(pbArray.get(i - 1).getName());
                    }

                    System.out.print("Дата рождения ( " + pbArray.get(i - 1).getbDay().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " ) -> ");
                    String readBDay = scan.nextLine();
                    if (!readBDay.isEmpty()) {
                        LocalDate inBDay = LocalDate.parse(readBDay, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                        pbArray.get(i - 1).setbDay(inBDay);
                        System.out.println(pbArray.get(i - 1).getbDay().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                    }
                    System.out.print("Адрес ( " + pbArray.get(i - 1).getAddress() + " ) -> ");
                    String inAddress = scan.nextLine();
                    if (!inAddress.isEmpty()) {
                        pbArray.get(i - 1).setAddress(inAddress);
                        System.out.println(pbArray.get(i - 1).getAddress());
                    }

                    // редактирование списка номеров
                    System.out.println("Редактирование списка номеров абонента. Символ \"+\" - добавление нового номера.");
                    while (true) {
                        for (int p = 0; p < pbArray.get(i - 1).phoneNumbers.size(); p++) {
                            System.out.println((p + 1) + ". " + pbArray.get(i - 1).phoneNumbers.get(p));

                        }
                        System.out.print("Сделайте выбор (Enter - выход) -> ");
                        String operation = scan.nextLine();
                        if (operation.equals("+")) {
                            // добавить новый номер
                            System.out.print("+380xxxxxxxxx -> ");
                            String inNumber = scan.nextLine();
                            if (!inNumber.isEmpty()) {
                                if (inNumber.matches("[+0-9]{5,13}")) {
                                    pbArray.get(i - 1).phoneNumbers.add(inNumber);

                                } else {
                                    System.out.println("Ошибка формата. Повторите ввод.");

                                }

                            }

                        } else {
                            // редактируем запись
                            if (operation.isEmpty()) {
                                // выход по Enter
                                break; // прерывание редактирования списка номеров абонентов
                            } else {
                                // если выбрали правильный номер записи
                                if (Integer.valueOf(operation) < pbArray.get(i - 1).phoneNumbers.size()) {
                                    Integer pp = Integer.valueOf(operation) - 1; // номер редактируемой записи
                                    System.out.print((pp + 1) + ". ( " + pbArray.get(i - 1).phoneNumbers.get(pp) + " ). \"-\" удалить эту запись -> ");
                                    String phone = scan.nextLine();
                                    if (phone.equals("-")) {
                                        // удалить номер из списка
                                        pbArray.get(i - 1).phoneNumbers.remove(pbArray.get(i - 1).phoneNumbers.get(pp));

                                    } else if (!phone.isEmpty()) {
                                        pbArray.get(i - 1).phoneNumbers.set(pp, phone);
                                        System.out.println(pbArray.get(i - 1).phoneNumbers.get(pp));
                                    }
                                }
                            }
                        }
                    }

                    break; // прерывание редактирования абонента
                }
            }

        }


    }

    public static void delPBitem() {
        if (pbArray.isEmpty()) {
            System.out.println("Книга пуста. Операция завершена.");

        } else {
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

    }

    public static void addPBitem() {
        Scanner scan = new Scanner(System.in);
        LinkedList<String> inPhoneNumbers = new LinkedList<>();

        // ввод данных ФИО, день рождения, адрес
        System.out.print("Новая запись в книге\nВведите ФИО -> ");
        String inName = scan.nextLine();
        System.out.print("Дата рождения dd.mm.yyyy -> ");
        LocalDate inBDay = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

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
            Scanner scan = new Scanner(System.in);

            System.out.print("Задайте способ сортировки.\n1. Без сортировки\n2. По ФИО\n3. По Адресу\n0. Завершить\n-> ");
            String option = scan.nextLine();

            switch (option) {
                case "0":
                    return;
                case "1":
                    System.out.println("Телефонная книга без сортировки.");
                    // вывод нумерованного списка
                    for (int i = 0; i < pbArray.size(); i++) {
                        System.out.println((i + 1) + ". " + pbArray.get(i).toString());
                    }
                    break;
                case "2":
                    System.out.println("Телефонная книга отсортирована по полю ФИО.");
                    // вывод списка без номера строки
                    pbArray.stream()
                            .sorted(Comparator.comparing(PhoneBookItem::getName))
                            .forEach(System.out::println);
                    break;

                case "3":
                    System.out.println("Телефонная книга отсортирована по полю Адрес.");
                    // вывод списка с номером строки, AtomicInteger подсказка IntelliJ
                    AtomicInteger iii = new AtomicInteger(1);
                    pbArray.stream()
                            .sorted(Comparator.comparing(PhoneBookItem::getAddress))
                            .forEach(
                                    pbi ->
                                    System.out.println((iii.getAndIncrement()) + ". " + pbi.toString())
                            );
                    break;
            }

        }
    }
}
