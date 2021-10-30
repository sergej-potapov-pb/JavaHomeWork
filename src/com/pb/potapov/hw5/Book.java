package com.pb.potapov.hw5;

/*
 * Класс описывает характеристики книги
 * - название
 * - автор книги
 * - год издания
 */
public class Book {

    public Book(String title, String author, String yearPublishing) {
        this.title = title;
        this.author = author;
        this.yearPublishing = yearPublishing;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearPublishing() {
        return yearPublishing;
    }

    public void setYearPublishing(String yearPublishing) {
        this.yearPublishing = yearPublishing;
    }

    private String title;
    private String author;
    private String yearPublishing;

    String getInfo() {
        return "Название: " + title + ", Автор: " + author + ", Год издания: " + yearPublishing ;
    }

}
