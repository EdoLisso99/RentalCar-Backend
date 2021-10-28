package com.example.rentalcar.repo;

import com.example.rentalcar.entities.Mezzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MezzoRepo extends CrudRepository<Mezzo, Long> {
    Optional<Mezzo> findById(Long id);
    void deleteById(Long id);

    @Query(value =  "SELECT * FROM Mezzo m WHERE m.id NOT IN " +
            "(SELECT p.auto FROM Prenotazione p WHERE p.accettata = true AND (" +
            "(p.data_di_inizio BETWEEN ?1 AND ?2) OR " +
            "(p.data_di_fine BETWEEN ?1 AND ?2) OR " +
            "(p.data_di_inizio < ?1 AND p.data_di_fine > ?2)))",
            nativeQuery = true)
    List<Mezzo> getAvailableMezzi(Date inizio, Date fine);

}

