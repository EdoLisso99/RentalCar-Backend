package com.example.rentalcar.repo;

import com.example.rentalcar.entities.Mezzo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MezzoRepo extends JpaRepository<Mezzo, Long> {
    Optional<Mezzo> findById(Long id);
    void deleteById(Long id);


}
