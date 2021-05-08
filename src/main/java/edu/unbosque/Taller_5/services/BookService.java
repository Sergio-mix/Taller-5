package edu.unbosque.Taller_5.services;

import edu.unbosque.Taller_5.jpa.entities.Author;
import edu.unbosque.Taller_5.jpa.entities.Book;
import edu.unbosque.Taller_5.jpa.repositories.AuthorRepository;
import edu.unbosque.Taller_5.jpa.repositories.AuthorRepositoryImpl;
import edu.unbosque.Taller_5.jpa.repositories.BookRepository;
import edu.unbosque.Taller_5.jpa.repositories.BookRepositoryImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class BookService {

    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public void saveBook(String title, String isbn, Integer authorId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);

        Optional<Author> author = authorRepository.findById(authorId);
        author.ifPresent(a -> {
            a.addBook(new Book(title, isbn));
            authorRepository.save(a);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }

}
