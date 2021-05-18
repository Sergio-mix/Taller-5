package edu.unbosque.Taller_5.servlets.pojos;

/**
 * Libary Pojo
 */
public class LibraryPOJO {

    private Integer libraryId;

    private String name;

    public LibraryPOJO() { }

    /**
     *
     * @param libraryId
     * @param name
     */
    public LibraryPOJO(Integer libraryId, String name) {
        this.libraryId = libraryId;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Integer getLibraryId() {
        return libraryId;
    }

    /**
     *
     * @param libraryId
     */
    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
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

}
