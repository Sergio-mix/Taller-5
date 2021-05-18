package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Author;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Interface AuthorRepository
 */
public interface AuthorRepository {
    /**
     *
     * @param id
     * @return
     */
    Optional<Author> findById(Integer id);

    /**
     *
     * @return
     */
    List<Author> findAll();

    /**
     *
     * @param author
     * @return
     */
    Optional<Author> save(Author author);

    /**
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     *
     * @param id
     * @param name
     * @param country
     * @return
     */
    String modify(Integer id, String name,String country);
}
