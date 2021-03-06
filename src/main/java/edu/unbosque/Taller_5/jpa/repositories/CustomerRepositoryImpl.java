package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Customer;
import edu.unbosque.Taller_5.jpa.entities.Library;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 *  Customer Repository Implementation
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    private EntityManager entityManager;

    /**
     *
     * @param entityManager
     */
    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     *
     * @param email
     * @return
     */
    public Optional<Customer> findByEmail(String email) {
        Customer customer = entityManager.find(Customer.class, email);
        return customer != null ? Optional.of(customer) : Optional.empty();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer").getResultList();
    }

    /**
     *
     * @param customer
     * @return
     */
    @Override
    public String save(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return "Customer registered";
        } catch (Exception e) {
            return "Error";
        }
    }

    /**
     *
     * @param email
     */
    @Override
    public void deleteByEmail(String email) {
        Customer customer = entityManager.find(Customer.class, email);
        if (customer != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(customer);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param email
     * @param firstName
     * @param lastName
     * @param gender
     * @param age
     * @return
     */
    @Override
    public String modify(String email, String firstName, String lastName, String gender, Integer age) {
        entityManager.getTransaction().begin();
        Optional<Customer> customer = this.findByEmail(email);
        if (customer.isPresent()) {
            customer.get().setEmail(email);
            customer.get().setFirst_name(firstName);
            customer.get().setLast_name(lastName);
            customer.get().setGender(gender);
            customer.get().setAge(age);
            entityManager.getTransaction().commit();
            return "Se ha modificado exitosamente!";
        }
        return "Error";
    }
}


