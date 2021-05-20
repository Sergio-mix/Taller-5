package edu.unbosque.Taller_5.jpa.entities;

import javax.persistence.*;
import java.util.*;

/**
 * Class Edition
 */
@Entity
@Table(name = "Edition") // Optional
@NamedQueries({
        @NamedQuery(name = "Edition.findAll",
                query = "SELECT b FROM Edition b")
})
public class Edition {

    @Id
    @GeneratedValue
    @Column(name = "edition_id")
    private Integer editionId;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Date releaseYear;
    @Column(name = "bookId")
    private Integer bookId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    // FetchType.EAGER: When we retrieve a Library, we'll also automatically retrieve all of its corresponding Editions
    // CascadeType.PERSIST: When we save a superhero, its movies will also be saved
    @ManyToMany(mappedBy = "edition", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Library> libraries = new HashSet<>();

    @OneToMany(mappedBy = "edition", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rent> rents = new ArrayList<>();

    public Edition() {}

    /**
     *
     * @param description
     * @param releaseYear
     * @param bookId
     */
    public Edition(String description, Date releaseYear,Integer bookId) {
        this.description = description;
        this.releaseYear = releaseYear;
        this.bookId = bookId;
    }

    /**
     * Constructor
     * @param editionId
     * @param description
     * @param releaseYear
     * @param bookId
     */
    public Edition(Integer editionId, String description, Date releaseYear,Integer bookId) {
        this.editionId = editionId;
        this.description = description;
        this.releaseYear = releaseYear;
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

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(Set<Library> libraries) {
        this.libraries = libraries;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
    public void addRent(Rent rent) {
        rents.add(rent);
        rent.setEdition(this);
    }


}
