package com.pb.potapov.hw5;


/*
 * Класс описывает информацию о пользователе библиотеки:
 * - ФИО
 * - номер читательского билета
 * - факультет
 * - дата рождения
 * - телефон
 */
public class Reader {

    public Reader(String fullName, String numberLibraryCard, String faculty, String dateBirth, String telephone) {
        this.fullName = fullName;
        this.numberLibraryCard = numberLibraryCard;
        this.faculty = faculty;
        this.dateBirth = dateBirth;
        this.telephone = telephone;
    }

    private String fullName;
    private String numberLibraryCard;
    private String faculty;
    private String dateBirth;
    private String telephone;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumberLibraryCard() {
        return numberLibraryCard;
    }

    public void setNumberLibraryCard(String numberLibraryCard) {
        this.numberLibraryCard = numberLibraryCard;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    String getInfo() {
        return "ФИО: " + fullName + ", номер билета: " + numberLibraryCard +
                ", факультет: " + faculty + ", дата рождения: " + dateBirth + ", телефон: " + telephone;
    }

    public void takeBook(int bookCount) {
        System.out.println(fullName + " взял " + bookCount + " книги");
    }

    public void takeBook(String ... titles) {
        if (titles.length != 0){
            System.out.print(fullName+" взял книги : ");

            for (String rTitles : titles) {
                System.out.print( rTitles+", ");
            }
            System.out.println("\b\b");
            takeBook(titles.length);
        }
    }

/*
 * Принимает переменный список взятых книг
 * @param объект книга
 */
    public void takeBook(Book... books) {
        if (books.length != 0){
            System.out.print(fullName+" взял книги : ");

            for (Book rBook: books) {
                System.out.print( rBook.getTitle()+"("+ rBook.getAuthor()+", "+ rBook.getYearPublishing()+"г), ");
            }
            System.out.println("\b\b");
            takeBook(books.length);
        }
    }


    public void returnBook(int bookCount) {
        System.out.println(fullName + " вернул " + bookCount + " книги");
    }

    public void returnBook(String ... titles) {
            if (titles.length != 0){
                System.out.print(fullName+" вернул книги : ");

                for (String rTitles : titles) {
                    System.out.print( rTitles+", ");
                }
                System.out.println("\b\b");
                returnBook(titles.length);
            }

    }

    /*
     * Принимает переменный список возвращаемых книг
     * @param объект книга
     */
    public void returnBook(Book... books) {
            if (books.length != 0){
                System.out.print(fullName+" вернул книги : ");

                for (Book rBook: books) {
                    System.out.print( rBook.getTitle()+"("+ rBook.getAuthor()+", "+ rBook.getYearPublishing()+"г), ");
                }
                System.out.println("\b\b");
                returnBook(books.length);
            }

    }

}
