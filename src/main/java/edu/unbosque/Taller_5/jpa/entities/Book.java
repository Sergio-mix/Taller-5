package edu.unbosque.Taller_5.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Book Class
 */
@Entity
@Table(name = "Book") // Optional
@NamedQueries({
        @NamedQuery(name = "Book.findByTitle",
                query = "SELECT b FROM Book b WHERE b.title = :title"),
        @NamedQuery(name = "Book.findAll",
                query = "SELECT b FROM Book b")
})
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Integer bookId;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(name = "isbn_number")
    private String isbn;
    @Column(name = "genre")
    private String genre;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne(mappedBy = "book")
    private Edition edition;

    public Book() {
    }

    /**
     *
     * @param title
     * @param isbn
     * @param genre
     */
    public Book(String title, String isbn, String genre) {
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
    }

    /**
     * Constructor
     * @param bookId
     * @param title
     * @param isbn
     * @param genre
     */
    public Book(Integer bookId, String title, String isbn, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Edition getEdition() {
        return edition;
    }

    public void addEdition(Edition edition) {
        this.edition = edition;
        edition.setBook(this);
    }


}
