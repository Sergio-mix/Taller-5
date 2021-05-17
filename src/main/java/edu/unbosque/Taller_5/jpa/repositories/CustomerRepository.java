package edu.unbosque.Taller_5.jpa.repositories;

import edu.unbosque.Taller_5.jpa.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    public List<Customer> findAll();
    public Optional<Customer> findById(Integer id);
    public Optional<Customer> save(Customer customer);
    void deleteByEmail(String email);
    String modify(Integer id,String email, String firstName, String lastName, String gender, Integer age);
}
