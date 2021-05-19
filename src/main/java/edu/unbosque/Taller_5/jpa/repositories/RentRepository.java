package edu.unbosque.Taller_5.jpa.repositories;


import edu.unbosque.Taller_5.jpa.entities.Rent;

import java.util.List;
import java.util.Optional;

public interface RentRepository {
    List<Rent> findAll();

    Optional<Rent> findById(Integer id);

    String save(Rent rent);

    void deleteByEmail(String email);

    String modify(String email);
}
