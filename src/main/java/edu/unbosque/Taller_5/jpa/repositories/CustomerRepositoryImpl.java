package edu.unbosque.Taller_5.jpa.repositories;


import edu.unbosque.Taller_5.jpa.entities.Customer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


    public class CustomerRepositoryImpl implements CustomerRepository {

        private EntityManager entityManager;


        public CustomerRepositoryImpl(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        public Optional<Customer> findByEmail(String email) {
            Customer customer = entityManager.find(Customer.class, email);
            return customer != null ? Optional.of(customer) : Optional.empty();
        }

        public List<Customer> findAll() {
            return entityManager.createQuery("from Customer").getResultList();
        }


        @Override
        public Optional<Customer> save(Customer customer) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(customer);
                entityManager.getTransaction().commit();

            } catch (Exception e) {

            }
            return Optional.empty();
        }


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

        @Override
        public String modify(String email, String firstName, String lastName, String gender, Integer age) {
            entityManager.getTransaction().begin();
            Optional<Customer> customer = this.findByEmail(email);
            if (!customer.isPresent())
                customer.get().setFirstName(firstName);
            customer.get().setLastName(lastName);
            customer.get().setGender(gender);
            customer.get().setAge(age);
            entityManager.getTransaction().commit();
            return "Se ha modificado exitosamente!";
        }


    }


