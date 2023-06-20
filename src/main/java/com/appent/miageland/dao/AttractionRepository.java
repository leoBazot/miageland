package com.appent.miageland.dao;

import com.appent.miageland.entities.Attraction;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface AttractionRepository extends CrudRepository<Attraction, Long> {

    /**
     * Recherche une attraction par son nom
     *
     * @param nom de l'attraction
     * @return l'attraction recherchée
     */
    Optional<Attraction> findByNom(String nom);

    /**
     * renvoie toutes les attractions
     *
     * @return une collection des toutes les attraction
     */
    Collection<Attraction> findAll();
}
