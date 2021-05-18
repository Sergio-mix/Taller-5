package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Edition;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *  Edition Repository
 */
public interface EditionRepository {
    /**
     *
     * @return
     */
    List<Edition> findAll();

    /**
     *
     * @param edition
     * @return
     */
    String save(Edition edition);

    /**
     *
     * @param id
     * @param description
     * @param release
     */
    void modify(Integer id, String description, Date release);

    /**
     *
     * @param id
     */
    void deleteById(Integer id);
}
