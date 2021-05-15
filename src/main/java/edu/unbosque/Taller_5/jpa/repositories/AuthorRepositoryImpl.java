package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Author;

import javax.persistence.EntityManager;
import javax.resource.cci.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AuthorRepositoryImpl implements AuthorRepository {

    private EntityManager entityManager;


    public AuthorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Author> findById(Integer id) {
        Author author = entityManager.find(Author.class, id);
        return author != null ? Optional.of(author) : Optional.empty();
    }

    public List<Author> findAll() {
        return entityManager.createQuery("from Author").getResultList();
    }

    public Optional<Author> findByName(String name) {
        Author author = entityManager.createNamedQuery("Author.findByName", Author.class)
                .setParameter("name", name)
                .getSingleResult();
        return author != null ? Optional.of(author) : Optional.empty();
    }

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

    @Override
    public Optional<Author> modify(String name) throws SQLException {
        Author author = entityManager.find(Author.class, name);
        String nom;
        Connection con = null;
        ResultSet rs;
        PreparedStatement ps;

        ps = con.prepareStatement("update usuario set Nombres='" + author + "'where author_id = +id");
        rs = (ResultSet) ps.executeQuery();


        ps.executeUpdate();
        if (author != null) {

            try {


} catch (Exception e) {
        e.printStackTrace();
        }
        }
        return Optional.of(author);
        }


        }
