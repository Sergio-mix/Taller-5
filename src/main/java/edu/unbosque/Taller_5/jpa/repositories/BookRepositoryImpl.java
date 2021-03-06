package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Author;
import edu.unbosque.Taller_5.jpa.entities.Book;
import edu.unbosque.Taller_5.jpa.entities.Library;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * BookRepository Implementation
 */
public class BookRepositoryImpl implements BookRepository {

    private EntityManager entityManager;
    private BookRepository bookRepository;

    /**
     *
     * @param entityManager
     */
    public BookRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Book> findById(Integer id) {
        Book book = entityManager.find(Book.class, id);
        return book != null ? Optional.of(book) : Optional.empty();
    }

    /**
     *
     * @param title
     * @return
     */
    public Optional<Book> findByTitle(String title) {
        Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class)
                .setParameter("title", title)
                .getSingleResult();
        return book != null ? Optional.of(book) : Optional.empty();
    }

    /**
     *
     * @param title
     * @return
     */
    public Optional<Book> findByTitleNamedQuery(String title) {
        Book book = entityManager.createNamedQuery("Book.findByTitle", Book.class)
                .setParameter("title", title)
                .getSingleResult();
        return book != null ? Optional.of(book) : Optional.empty();
    }

    /**
     *
     * @return
     */
    public List<Book> findAll() {
        return entityManager.createQuery("from Book").getResultList();
    }

    /**
     *
     * @param book
     * @return
     */
    public Optional<Book> save(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
            return Optional.of(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     *
     * @param id
     * @param title
     * @param isbn
     * @param genre
     */
    @Override
    public void modify(Integer id, String title, String isbn, String genre) {
        entityManager.getTransaction().begin();
        Optional<Book> book = this.findById(id);
        if (!book.isPresent())
            book.get().setTitle(title);
            book.get().setIsbn(isbn);
            book.get().setTitle(title);
            book.get().setGenre(genre);
            entityManager.getTransaction().commit();


    }

    /**
     *
     * @param bookId
     */
    @Override
    public void deleteById(Integer bookId) {
//        Book book = entityManager.find(Book.class, bookId);
//        if (book != null) {
//            try {
//                entityManager.getTransaction().begin();
//                entityManager.remove(book);
//                entityManager.getTransaction().commit();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
            entityManager.getTransaction().begin();
            Optional<Book> books = this.findById(bookId);

            books.ifPresent(book -> {

                entityManager.remove(book);

                entityManager.getTransaction().commit();

            });

//        entityManager.getTransaction().begin();
//        Optional<Book> book1 = this.findById(bookId);
//        Author author = entityManager.find(Author.class, book1.get().getAuthor().getAuthorId());
//        if (author != null) {
//            try {
//                author.getBooks().forEach(book -> {
//                    entityManager.remove(book);
//                });
//                System.out.println(book1.get()+"AQUIIIIIIIIIII");
//                entityManager.remove(book1.get());
//                entityManager.getTransaction().commit();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        }

    }


