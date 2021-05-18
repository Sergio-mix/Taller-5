package edu.unbosque.Taller_5.services;

import edu.unbosque.Taller_5.jpa.entities.Customer;
import edu.unbosque.Taller_5.jpa.repositories.*;
import edu.unbosque.Taller_5.servlets.pojos.CustomerPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer Service
 */
@Stateless
public class CustomerService {

    CustomerRepository customerRepository;

    /**
     *
     * @return
     */
    public List<CustomerPOJO> listCustomers() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);

        List<Customer> customers = customerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<CustomerPOJO> customersPOJO = new ArrayList<>();
        for (Customer customer : customers) {
            customersPOJO.add(new CustomerPOJO(
                    customer.getEmail(),
                    customer.getFirst_name(),
                    customer.getLast_name(),
                    customer.getGender(),
                    customer.getAge()
            ));
        }
        return customersPOJO;
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
    public String saveCustomer(String email, String firstName, String lastName, String gender, Integer age) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        customerRepository = new CustomerRepositoryImpl(entityManager);
        Customer customer = new Customer(email, firstName, lastName, gender, age);
        String persistedCustomer = customerRepository.save(customer);
        entityManager.close();
        entityManagerFactory.close();

        return persistedCustomer;
    }

    /**
     *
     * @param email
     */
    public void deleteCustomer(String email) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        customerRepository = new CustomerRepositoryImpl(entityManager);

        customerRepository.deleteByEmail(email);

        entityManager.close();
        entityManagerFactory.close();

    }

    /**
     *
     * @param email
     * @param firstName
     * @param lastName
     * @param gender
     * @param age
     */
    public void modifyCustomer(String email, String firstName, String lastName, String gender, Integer age) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);

        customerRepository.modify(email, firstName, lastName, gender, age);

        entityManager.close();
        entityManagerFactory.close();

    }

}
