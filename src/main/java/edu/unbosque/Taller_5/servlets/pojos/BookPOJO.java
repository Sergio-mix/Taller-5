package edu.unbosque.Taller_5.servlets.pojos;


public class BookPOJO {

    private String author;
    private String name;
    private String ISBN;


    public BookPOJO(String author, String name, String ISBN) {
        this.author = author;
        this.name = name;
        this.ISBN = ISBN;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }


}
