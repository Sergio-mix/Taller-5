package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Edition;


import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Edition Repository Implementation
 */
public class EditionRepositoryImpl implements EditionRepository {

    private EntityManager entityManager;

    /**
     *
     * @param entityManager
     */
    public EditionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Edition> findAll() {
        return entityManager.createQuery("from Edition").getResultList();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Edition> findById(Integer id) {
        Edition edition = entityManager.find(Edition.class, id);
        return edition != null ? Optional.of(edition) : Optional.empty();
    }

    /**
     *
     * @param edition
     * @return
     */
    @Override
        public String save(Edition edition) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(edition);
            entityManager.getTransaction().commit();
            return "Edition registered";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error";
    }

    /**
     *
     * @param id
     * @param description
     * @param release
     */
    @Override
    public void modify(Integer id, String description, Date release) {
        entityManager.getTransaction().begin();
        Optional<Edition> edition = this.findById(id);
        if (edition.isPresent())
            edition.get().setDescription(description);
        edition.get().setReleaseYear(release);
        entityManager.getTransaction().commit();

    }

    /**
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        Edition edition = entityManager.find(Edition.class, id);
        if (edition != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(edition);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
