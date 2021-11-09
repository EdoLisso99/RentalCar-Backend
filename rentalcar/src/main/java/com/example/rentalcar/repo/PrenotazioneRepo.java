package com.example.rentalcar.repo;

import com.example.rentalcar.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {

    Optional<Prenotazione> findById(Long id);

    void deleteById(Long id);


}
