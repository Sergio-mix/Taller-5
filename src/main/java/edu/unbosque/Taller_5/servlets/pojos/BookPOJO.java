package edu.unbosque.Taller_5.servlets.pojos;

import edu.unbosque.Taller_5.jpa.entities.Author;
import edu.unbosque.Taller_5.jpa.entities.Edition;

public class BookPOJO {

    private Author author;
    private String name;
    private String ISBN;
    private Edition edition;

    public BookPOJO(Author author, String name, String ISBN, Edition edition) {
        this.author = author;
        this.name = name;
        this.ISBN = ISBN;
        this.edition = edition;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
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

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }
}
