package com.appent.miageland.dao;

import com.appent.miageland.entities.Attraction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttractionRepository extends CrudRepository<Attraction, Long> {

    /**
     * Recherche des attractions par nom
     */
    List<Attraction> findByNom(String nom);
}
