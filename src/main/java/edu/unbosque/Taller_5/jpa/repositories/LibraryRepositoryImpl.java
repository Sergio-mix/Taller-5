package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Author;
import edu.unbosque.Taller_5.jpa.entities.Book;
import edu.unbosque.Taller_5.jpa.entities.Library;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class LibraryRepositoryImpl implements LibraryRepository {

    private EntityManager entityManager;

    public LibraryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Library> findAll() {
        return entityManager.createQuery("from Library").getResultList();
    }

    public Optional<Library> findById(Integer id) {
        Library library = entityManager.find(Library.class, id);
        return library != null ? Optional.of(library) : Optional.empty();
    }

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

    @Override
    public void modify(Integer id, String name) {
        entityManager.getTransaction().begin();
        Optional<Library> library = this.findById(id);
        if (library.isPresent())
            library.get().setName(name);
        entityManager.getTransaction().commit();

    }

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
