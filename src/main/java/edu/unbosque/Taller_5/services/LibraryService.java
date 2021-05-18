package edu.unbosque.Taller_5.services;

import edu.unbosque.Taller_5.jpa.entities.Library;
import edu.unbosque.Taller_5.jpa.repositories.AuthorRepositoryImpl;
import edu.unbosque.Taller_5.jpa.repositories.BookRepositoryImpl;
import edu.unbosque.Taller_5.jpa.repositories.LibraryRepository;
import edu.unbosque.Taller_5.jpa.repositories.LibraryRepositoryImpl;

import edu.unbosque.Taller_5.servlets.pojos.LibraryPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Library Service class
 */
@Stateless
public class LibraryService {

    LibraryRepository libraryRepository;

    /**
     *
     * @return
     */
    public List<LibraryPOJO> listLibraries() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);
        List<Library> libraries = libraryRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<LibraryPOJO> librariesPOJO = new ArrayList<>();
        for (Library library : libraries) {
            librariesPOJO.add(new LibraryPOJO(
                    library.getLibraryId(),
                    library.getName()
            ));
        }

        return librariesPOJO;

    }

    /**
     *
     * @param name
     */
    public void saveLibrary(String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);

        Library library = new Library(name);
        Library persistedLibrary = libraryRepository.save(library).get();

        entityManager.close();
        entityManagerFactory.close();

    }

    /**
     *
     * @param id
     * @param name
     */
    public void modifyLibrary(Integer id,String name){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);
        libraryRepository.modify(id,name);

        entityManager.close();
        entityManagerFactory.close();

    }

    /**
     *
     * @param id
     */
    public void deleteLibrary(Integer id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        libraryRepository = new LibraryRepositoryImpl(entityManager);

        libraryRepository.deleteById(id);

        entityManager.close();
        entityManagerFactory.close();

    }

}
