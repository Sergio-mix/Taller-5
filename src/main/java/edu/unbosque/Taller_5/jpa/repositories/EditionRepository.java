package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Edition;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EditionRepository {
    List<Edition> findAll();

    String save(Edition edition);

    void modify(Integer id, String description, Date release);

    void deleteById(Integer id);
}
