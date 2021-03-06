package edu.unbosque.Taller_5.services;

import edu.unbosque.Taller_5.jpa.entities.Author;
import edu.unbosque.Taller_5.jpa.entities.Book;
import edu.unbosque.Taller_5.jpa.repositories.AuthorRepository;
import edu.unbosque.Taller_5.jpa.repositories.AuthorRepositoryImpl;
import edu.unbosque.Taller_5.jpa.repositories.BookRepository;
import edu.unbosque.Taller_5.jpa.repositories.BookRepositoryImpl;
import edu.unbosque.Taller_5.servlets.pojos.AuthorPOJO;
import edu.unbosque.Taller_5.servlets.pojos.BookPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Book Service Class
 */
@Stateless
public class BookService {

    AuthorRepository authorRepository;
    BookRepository bookRepository;
    Book book;

    /**
     *
     * @return
     */
    public List<BookPOJO> listBooks() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        List<Book> books = bookRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<BookPOJO> booksPOJO = new ArrayList<>();
        for (Book book : books) {
            booksPOJO.add(new BookPOJO(
                    book.getBookId(),
                    book.getAuthor().getName(),
                    book.getTitle(),
                    book.getIsbn(),
                    book.getGenre()
            ));
        }

        return booksPOJO;

    }

    /**
     *
     * @param title
     * @param isbn
     * @param genre
     * @param authorId
     */
    public void saveBook(String title, String isbn,String genre, Integer authorId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);

        Optional<Author> author = authorRepository.findById(authorId);
        author.ifPresent(a -> {
            a.addBook(new Book(title, isbn,genre));
            authorRepository.save(a);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }

    /**
     *
     * @param bookId
     */
    public void deleteBook(Integer bookId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        authorRepository = new AuthorRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);
        Optional<Book> book = bookRepository.findById(bookId);

        authorRepository.findById(book.get().getAuthor().getAuthorId()).get().deleteBook(bookRepository.findById(bookId).get());
        bookRepository.deleteById(bookId);
        entityManager.close();

        entityManagerFactory.close();

    }

    /**
     *
     * @param id
     * @param title
     * @param isbn
     * @param genre
     */
    public void modifyBook(Integer id,String title,String isbn,String genre){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);
        bookRepository.modify(id,title,isbn,genre);

        entityManager.close();
        entityManagerFactory.close();

    }

}
