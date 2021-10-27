package com.example.rentalcar.repo;

import com.example.rentalcar.entities.Utente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepo extends CrudRepository<Utente, Long> {
    Optional<Utente> findById(Long id);
    void deleteById(Long id);
}
