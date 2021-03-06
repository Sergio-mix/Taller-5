package edu.unbosque.Taller_5.services;


import edu.unbosque.Taller_5.jpa.entities.Author;
import edu.unbosque.Taller_5.jpa.entities.Book;
import edu.unbosque.Taller_5.jpa.entities.Edition;
import edu.unbosque.Taller_5.jpa.entities.Library;
import edu.unbosque.Taller_5.jpa.repositories.*;
import edu.unbosque.Taller_5.servlets.pojos.EditionPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Edition Service Class
 */
@Stateless
public class EditionService {
    EditionRepository editionRepository;
    LibraryRepository libraryRepository;

    /**
     *
     * @return
     */
    public List<EditionPOJO> listEditions() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        List<Edition> editions = editionRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<EditionPOJO> editionsPOJO = new ArrayList<>();
        for (Edition edition : editions) {
            editionsPOJO.add(new EditionPOJO(
                    edition.getEditionId(),
                    edition.getDescription(),
                    edition.getReleaseYear(),
                    edition.getBookId()
            ));
        }

        return editionsPOJO;

    }

    /**
     *
     * @param description
     * @param release
     * @param bookId
     * @return
     */
    public String saveEdition(String description, Date release,Integer bookId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        editionRepository = new EditionRepositoryImpl(entityManager);
        Edition edition = new Edition(description,release,bookId);
        String persistedEdition = editionRepository.save(edition);
        entityManager.close();
        entityManagerFactory.close();

        return persistedEdition;

    }

    /**
     *
     * @param editionId
     */
    public void deleteEdition(Integer editionId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        editionRepository.deleteById(editionId);

        entityManager.close();
        entityManagerFactory.close();

    }

    /**
     *
     * @param id
     * @param description
     * @param release
     */
    public void modifyEdition(Integer id,String description, Date release) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        editionRepository.modify(id,description,release);

        entityManager.close();
        entityManagerFactory.close();

    }



}
