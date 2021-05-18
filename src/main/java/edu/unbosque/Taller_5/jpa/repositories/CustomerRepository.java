package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Customer;

import java.util.List;
import java.util.Optional;

/**
 *  Customer Repository
 */
public interface CustomerRepository {
    List<Customer> findAll();

    Optional<Customer> findByEmail(String email);

    String save(Customer customer);

    void deleteByEmail(String email);

    String modify(String email, String firstName, String lastName, String gender, Integer age);
}
