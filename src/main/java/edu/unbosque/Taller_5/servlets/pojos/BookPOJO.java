package edu.unbosque.Taller_5.servlets.pojos;


public class BookPOJO {
    private Integer bookId;
    private String author;
    private String title;
    private String isbn;
    private String genre;

    public BookPOJO() {
    }

    public BookPOJO(Integer bookId, String author, String title, String isbn, String genre) {
        this.bookId = bookId;
        this.author = author;
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


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
}
