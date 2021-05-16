package edu.unbosque.Taller_5.servlets.pojos;

public class AuthorPOJO {

    private Integer authorId;

    private String name;

    private String country;

    private Integer numBooks;

    public AuthorPOJO() {
    }

    public AuthorPOJO(Integer authorId, String name, String country, Integer numBooks) {
        this.authorId = authorId;
        this.name = name;
        this.country = country;
        this.numBooks = numBooks;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getNumBooks() {
        return numBooks;
    }

    public void setNumBooks(Integer numBooks) {
        this.numBooks = numBooks;
    }

}
