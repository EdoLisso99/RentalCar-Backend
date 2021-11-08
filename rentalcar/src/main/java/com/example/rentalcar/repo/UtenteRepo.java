package com.example.rentalcar.repo;

import com.example.rentalcar.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
    Optional<Utente> findById(Long id);

    void deleteById(Long id);

    Optional<Utente> findByUsername(String username);

    Optional<Utente> findByRuolo(String ruolo);

}
