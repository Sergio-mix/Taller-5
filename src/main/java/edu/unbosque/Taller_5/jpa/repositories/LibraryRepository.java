package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Library;

import java.util.List;
import java.util.Optional;

/**
 *  Library Repository
 */
public interface LibraryRepository {

    List<Library> findAll();

    Optional<Library> save(Library library);
    public void modify(Integer id, String name);
    public void deleteById(Integer id);
   public void associateEdition(Integer Editionid ,Integer id);

    public void disassociateEdition(Integer id);
}
