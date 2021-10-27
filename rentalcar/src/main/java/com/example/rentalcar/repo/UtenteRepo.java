package com.example.rentalcar.repo;

import com.example.rentalcar.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepo extends JpaRepository<Utente, Long> {
    Optional<Utente> findById(Long id);
    void deleteById(Long id);
}
