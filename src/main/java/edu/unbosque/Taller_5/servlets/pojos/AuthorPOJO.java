package edu.unbosque.Taller_5.servlets.pojos;

/**
 * Class Author Pojo
 */
public class AuthorPOJO {

    private Integer authorId;

    private String name;

    private String country;

    private Integer numBooks;

    public AuthorPOJO() {
    }

    /**
     * Contructor
     * @param authorId
     * @param name
     * @param country
     * @param numBooks
     */
    public AuthorPOJO(Integer authorId, String name, String country, Integer numBooks) {
        this.authorId = authorId;
        this.name = name;
        this.country = country;
        this.numBooks = numBooks;
    }

    /**
     *
     * @return
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     *
     * @param authorId
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     */
    public Integer getNumBooks() {
        return numBooks;
    }

    /**
     *
     * @param numBooks
     */
    public void setNumBooks(Integer numBooks) {
        this.numBooks = numBooks;
    }

}
