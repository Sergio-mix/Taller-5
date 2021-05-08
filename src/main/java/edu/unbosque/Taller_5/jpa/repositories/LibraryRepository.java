package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository {

    List<Library> findAll();

    Optional<Library> save(Library library);

}