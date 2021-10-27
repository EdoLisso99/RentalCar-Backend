package com.example.rentalcar.repo;

import com.example.rentalcar.entities.Prenotazione;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrenotazioneRepo extends CrudRepository<Prenotazione, Long> {

    Optional<Prenotazione> findById(Long id);
    void deleteById(Long id);
}
