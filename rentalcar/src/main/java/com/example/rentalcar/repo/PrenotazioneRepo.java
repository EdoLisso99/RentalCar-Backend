package com.example.rentalcar.repo;

import com.example.rentalcar.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {

    Optional<Prenotazione> findById(Long id);
    void deleteById(Long id);
}
