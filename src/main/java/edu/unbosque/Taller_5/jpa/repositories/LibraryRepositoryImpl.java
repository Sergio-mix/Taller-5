package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Author;
import edu.unbosque.Taller_5.jpa.entities.Book;
import edu.unbosque.Taller_5.jpa.entities.Library;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * Library Repository Implementation
 */
public class LibraryRepositoryImpl implements LibraryRepository {

    private EntityManager entityManager;

    /**
     *
     * @param entityManager
     */
    public LibraryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Library> findAll() {
        return entityManager.createQuery("from Library").getResultList();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Library> findById(Integer id) {
        Library library = entityManager.find(Library.class, id);
        return library != null ? Optional.of(library) : Optional.empty();
    }

    /**
     *
     * @param library
     * @return
     */
    @Override
    public Optional<Library> save(Library library) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(library);
            entityManager.getTransaction().commit();
            return Optional.of(library);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     *
     * @param id
     * @param name
     */
    @Override
    public void modify(Integer id, String name) {
        entityManager.getTransaction().begin();
        Optional<Library> library = this.findById(id);
        if (library.isPresent())
            library.get().setName(name);
        entityManager.getTransaction().commit();

    }

    @Override
    public void associateEdition(Integer idEdition, Integer id) {
        entityManager.getTransaction().begin();
        Optional<Library> library = this.findById(id);
        System.out.println("AQUIIIII"+id+"     "+idEdition);
        if (library.isPresent())
            library.get().setEditionId(idEdition);
        entityManager.getTransaction().commit();
    }

    @Override
    public void disassociateEdition(Integer id) {
        entityManager.getTransaction().begin();
        Optional<Library> library = this.findById(id);
        if (library.isPresent())
            library.get().setEditionId(null);
        entityManager.getTransaction().commit();
    }


    /**
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        Library library = entityManager.find(Library.class, id);
        if (library != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(library);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
