package com.example.rentalcar.repo;

import com.example.rentalcar.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {

    Optional<Prenotazione> findById(Long id);

    void deleteById(Long id);
}
