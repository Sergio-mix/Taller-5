package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Book;

import java.util.List;
import java.util.Optional;

/**
 * Interface BookRepository
 */
public interface BookRepository {
    /**
     *
     * @param id
     * @return
     */
    Optional<Book> findById(Integer id);

    /**
     *
     * @param title
     * @return
     */
    Optional<Book> findByTitle(String title);

    /**
     *
     * @param title
     * @return
     */
    Optional<Book> findByTitleNamedQuery(String title);

    /**
     *
     * @return
     */
    List<Book> findAll();

    /**
     *
     * @param book
     * @return
     */
    Optional<Book> save(Book book);

    /**
     *
     * @param idBook
     */
    void deleteById(Integer idBook);

    /**
     *
     * @param id
     * @param title
     * @param isbn
     * @param genre
     */
    void modify(Integer id, String title, String isbn, String genre);


}
