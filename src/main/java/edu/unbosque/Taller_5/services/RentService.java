//package edu.unbosque.Taller_5.services;
//
//import edu.unbosque.Taller_5.jpa.entities.Author;
//import edu.unbosque.Taller_5.jpa.entities.Rent;
//import edu.unbosque.Taller_5.jpa.repositories.AuthorRepositoryImpl;
//import edu.unbosque.Taller_5.jpa.repositories.RentRepository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class RentService {
//
//    RentRepository rentRepository;
//
//    public Rent saveRent(){
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        rentRepository = new rentRepositoryImpl(entityManager);
////        Author author = new Author(name,country);
//        Rent persistedRent = rentRepository.save(rent).get();
//        entityManager.close();
//        entityManagerFactory.close();
//
//        return persistedRent;
//    }
//}
