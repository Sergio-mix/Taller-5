package edu.unbosque.Taller_5.servlets.pojos;

/**
 * Libary Pojo
 */
public class LibraryPOJO {

    private Integer libraryId;

    private String name;
    private  Integer EditionId;

    public LibraryPOJO(Integer libraryId, String name, Integer editionId) {
        this.libraryId = libraryId;
        this.name = name;
        EditionId = editionId;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEditionId() {
        return EditionId;
    }

    public void setEditionId(Integer editionId) {
        EditionId = editionId;
    }
}
