package com.appent.miageland.dao;

import com.appent.miageland.entities.Attraction;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AttractionRepository extends CrudRepository<Attraction, Long> {

    /**
     * Recherche une attraction par son nom
     *
     * @param nom de l'attraction
     * @return l'attraction recherchée
     */
    Optional<Attraction> findByNom(String nom);
}
