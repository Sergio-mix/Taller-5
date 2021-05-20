package edu.unbosque.Taller_5.services;
import edu.unbosque.Taller_5.jpa.entities.Edition;
import edu.unbosque.Taller_5.jpa.entities.Rent;
import edu.unbosque.Taller_5.jpa.repositories.*;
import edu.unbosque.Taller_5.servlets.pojos.RentPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

public class RentService {

    RentRepository rentRepository;
    EditionRepository editionRepository;

    public List<RentPOJO> listRent() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        List<Rent> rents = rentRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<RentPOJO> rentPOJO = new ArrayList<>();
        for (Rent rent : rents) {
            rentPOJO.add(new RentPOJO(
                    rent.getRentId(),
                    rent.getEmail(),
                    rent.getEdition().getEditionId(),
                    rent.getRenting_date()
            ));
        }

        return rentPOJO;

    }

    public void saveRent(String email, Integer edition_id, String rentingDate) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        editionRepository = new EditionRepositoryImpl(entityManager);

        Optional<Edition> edition = editionRepository.findById(edition_id);
        edition.ifPresent(a -> {
            a.addRent(new Rent(email, rentingDate));
            editionRepository.save(a);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;
    }
}
