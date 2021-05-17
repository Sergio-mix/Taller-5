package edu.unbosque.Taller_5.services;

import edu.unbosque.Taller_5.jpa.entities.Author;
import edu.unbosque.Taller_5.jpa.entities.Customer;
import edu.unbosque.Taller_5.jpa.repositories.*;
import edu.unbosque.Taller_5.servlets.pojos.CustomerPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerService {

    CustomerRepository customerRepository;

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
                    customer.getCustomerId(),
                    customer.getEmail(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getGender(),
                    customer.getAge()
            ));
        }

        return customersPOJO;

    }

    public void saveCustomer(String email, String firstName, String lastName, String gender, Integer age) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        customerRepository = new CustomerRepositoryImpl(entityManager);
        Customer customer = new Customer(email,firstName, lastName,  gender,  age);
        Customer persistedCustomer = customerRepository.save(customer).get();
        entityManager.close();
        entityManagerFactory.close();

    }

    public void deleteCustomer(String email) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        customerRepository = new CustomerRepositoryImpl(entityManager);

        customerRepository.deleteByEmail(email);

        entityManager.close();
        entityManagerFactory.close();

    }

    public void modifyCustomer(Integer id,String email, String firstName, String lastName, String gender,Integer age) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);

        customerRepository.modify(id,email, firstName, lastName, gender,age);

        entityManager.close();
        entityManagerFactory.close();

    }

}
