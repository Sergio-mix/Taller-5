//package edu.unbosque.Taller_5.jpa.repositories;
//
//import edu.unbosque.Taller_5.jpa.entities.Book;
//import edu.unbosque.Taller_5.jpa.entities.Rent;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//import java.util.Optional;
//
//public class RentRepositoryImpl {
//    private EntityManager entityManager;
//    private RentRepository rentRepository;
//
//    /**
//     *
//     * @param entityManager
//     */
//    public RentRepositoryImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    /**
//     *
//     * @param id
//     * @return
//     */
//    public Optional<Book> findById(Integer id) {
//        Book book = entityManager.find(Book.class, id);
//        return book != null ? Optional.of(book) : Optional.empty();
//    }
//
//    /**
//     *
//     * @param title
//     * @return
//     */
//    public Optional<Book> findByTitle(String title) {
//        Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class)
//                .setParameter("title", title)
//                .getSingleResult();
//        return book != null ? Optional.of(book) : Optional.empty();
//    }
//
//    /**
//     *
//     * @param title
//     * @return
//     */
//    public Optional<Book> findByTitleNamedQuery(String title) {
//        Book book = entityManager.createNamedQuery("Book.findByTitle", Book.class)
//                .setParameter("title", title)
//                .getSingleResult();
//        return book != null ? Optional.of(book) : Optional.empty();
//    }
//
//    /**
//     *
//     * @return
//     */
//    public List<Book> findAll() {
//        return entityManager.createQuery("from Book").getResultList();
//    }
//
//    /**
//     *
//     * @param book
//     * @return
//     */
//    public Optional<Book> save(Book book) {
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(book);
//            entityManager.getTransaction().commit();
//            return Optional.of(book);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }
//
//    /**
//     *
//     * @param id
//     * @param title
//     * @param isbn
//     * @param genre
//     */
//    @Override
//    public void modify(Integer id, String title, String isbn, String genre) {
//        entityManager.getTransaction().begin();
//        Optional<Book> book = this.findById(id);
//        if (!book.isPresent())
//            book.get().setTitle(title);
//        book.get().setIsbn(isbn);
//        book.get().setTitle(title);
//        book.get().setGenre(genre);
//        entityManager.getTransaction().commit();
//
//
//    }
//
//    /**
//     *
//     * @param bookId
//     */
//    @Override
//    public void deleteById(Integer bookId) {
//
//
//    }
//}
