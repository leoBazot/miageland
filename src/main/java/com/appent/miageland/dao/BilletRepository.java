package com.appent.miageland.dao;

import com.appent.miageland.entities.Billet;
import org.springframework.data.repository.CrudRepository;

public interface BilletRepository extends CrudRepository<Billet, Long> {

    /**
     * Recherche de l'état d'un billet par son id
     *
     * @param id l'id du billet
     * @return l'état du billet
     */
    Billet findEtatById(Long id);
}
