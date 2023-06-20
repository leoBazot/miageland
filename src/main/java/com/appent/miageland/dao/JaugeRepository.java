package com.appent.miageland.dao;

import com.appent.miageland.entities.Jauge;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface JaugeRepository extends CrudRepository<Jauge, Long> {
    /**
     * renvoye la jauge pour une date donnée
     *
     * @param jour souhaité
     * @return la jauge
     */
    Optional<Jauge> findByJour(LocalDate jour);

}
