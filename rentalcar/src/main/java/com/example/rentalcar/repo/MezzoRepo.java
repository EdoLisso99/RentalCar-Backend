package com.example.rentalcar.repo;

import com.example.rentalcar.entities.Mezzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MezzoRepo extends CrudRepository<Mezzo, Long> {
    Optional<Mezzo> findById(Long id);
    void deleteById(Long id);


}
