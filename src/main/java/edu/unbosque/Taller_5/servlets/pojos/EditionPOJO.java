package edu.unbosque.Taller_5.servlets.pojos;

import java.util.Date;

public class EditionPOJO {
    private Integer editionId;
    private String description;
    private Date release;
    private Integer bookId;

    public EditionPOJO(String description, Date release,Integer bookId) {
        this.description = description;
        this.release = release;
        this.bookId = bookId;
    }

    public EditionPOJO(Integer editionId, String description, Date release,Integer bookId) {
        this.editionId = editionId;
        this.description = description;
        this.release = release;
        this.bookId = bookId;
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
