package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Author;

import javax.persistence.EntityManager;
import javax.resource.cci.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Clase AuthorRepository Implementation
 */
public class AuthorRepositoryImpl implements AuthorRepository {

    private EntityManager entityManager;

    /**
     *
     * @param entityManager
     */
    public AuthorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Author> findById(Integer id) {
        Author author = entityManager.find(Author.class, id);
        return author != null ? Optional.of(author) : Optional.empty();
    }

    /**
     *
     * @return
     */
    public List<Author> findAll() {
        return entityManager.createQuery("from Author").getResultList();
    }

    public Optional<Author> findByName(String name) {
        Author author = entityManager.createNamedQuery("Author.findByName", Author.class)
                .setParameter("name", name)
                .getSingleResult();

        return author != null ? Optional.of(author) : Optional.empty();
    }

    /**
     *
     * @param author
     * @return
     */
    public Optional<Author> save(Author author) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(author);
            entityManager.getTransaction().commit();
            return Optional.of(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        Author author = entityManager.find(Author.class, id);
        if (author != null) {
            try {

                entityManager.getTransaction().begin();

                author.getBooks().forEach(book -> {
                    entityManager.remove(book);
                });

                entityManager.remove(author);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param id
     * @param name
     * @param country
     * @return
     */
    @Override
    public String modify(Integer id, String name,String country) {
        entityManager.getTransaction().begin();
        Optional<Author> author = this.findById(id);
        if (!author.isPresent())
            author.get().setName(name);
            author.get().setName(name);
        author.get().setCountry(country);
        entityManager.getTransaction().commit();
        return "Se ha modificado exitosamente!";
    }


}
