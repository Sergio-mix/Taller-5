package edu.unbosque.Taller_5.servlets.pojos;

import java.util.Date;

/**
 * Class Edition Pojo
 */
public class EditionPOJO {
    private Integer editionId;
    private String description;
    private Date release;
    private Integer bookId;

    /**
     *
     * @param description
     * @param release
     * @param bookId
     */
    public EditionPOJO(String description, Date release,Integer bookId) {
        this.description = description;
        this.release = release;
        this.bookId = bookId;
    }

    /**
     * Constructor
     * @param editionId
     * @param description
     * @param release
     * @param bookId
     */
    public EditionPOJO(Integer editionId, String description, Date release,Integer bookId) {
        this.editionId = editionId;
        this.description = description;
        this.release = release;
        this.bookId = bookId;
    }

    /**
     *
     * @return
     */
    public Integer getEditionId() {
        return editionId;
    }

    /**
     *
     * @param editionId
     */
    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public Date getRelease() {
        return release;
    }

    /**
     *
     * @param release
     */
    public void setRelease(Date release) {
        this.release = release;
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
}
