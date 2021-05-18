package edu.unbosque.Taller_5.servlets.pojos;

/**
 * Book Pojo
 */
public class BookPOJO {
    private Integer bookId;
    private String author;
    private String title;
    private String isbn;
    private String genre;

    public BookPOJO() {
    }

    /**
     * Constructor
     * @param bookId
     * @param author
     * @param title
     * @param isbn
     * @param genre
     */
    public BookPOJO(Integer bookId, String author, String title, String isbn, String genre) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;

    }

    /**
     *
     * @return
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     *
     * @param bookId
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @return
     */
    public String getGenre() {
        return genre;
    }

    /**
     *
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
