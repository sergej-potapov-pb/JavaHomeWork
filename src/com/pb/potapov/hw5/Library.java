package com.pb.potapov.hw5;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Приключения","Иванов И.И.","2000");
        Book book2 = new Book("Словарь","Сидоров А.В.","1980");
        Book book3 = new Book("Энциклопедия","Гусев К.В.","2010");
        Reader reader1 = new Reader("Петров В.В.","10001","АК-83","31.10.1998","555-1234");
        Reader reader2 = new Reader("Иванов А.А.","10010","АК-84","01.10.1999","555-4123");

        System.out.println("Перечень книг библиотеки:");
        System.out.println("\t"+book1.getInfo());
        System.out.println("\t"+book2.getInfo());
        System.out.println("\t"+book3.getInfo());

        System.out.println("\nПеречень читателей:");
        System.out.println("\t"+reader1.getInfo());
        System.out.println("\t"+reader2.getInfo());

        System.out.println("\nЧитатели берут книги.");
        reader1.takeBook(book1, book2, book3);
        reader2.takeBook(book1, book3);
        System.out.println("\n");
        reader1.takeBook(book1.getTitle(), book2.getTitle(), book3.getTitle());
        reader2.takeBook(book2.getTitle(), book3.getTitle());

        System.out.println("\nЧитатели возвращают книги.");
        reader1.returnBook(book3, book2, book1);
        reader2.returnBook(book2, book1);
        System.out.println("\n");
        reader1.returnBook(book2.getTitle(), book3.getTitle(), book1.getTitle());
        reader2.returnBook(book3.getTitle(), book1.getTitle());

    }
}
