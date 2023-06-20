package com.appent.miageland.dao;

import com.appent.miageland.entities.Billet;
import com.appent.miageland.export.EtatBillet;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface BilletRepository extends CrudRepository<Billet, Long> {

    /**
     * Recherche de l'état d'un billet par son id
     *
     * @param id l'id du billet
     * @return l'état du billet
     */
    Optional<EtatBillet> findEtatById(Long id);

    /**
     * Compte le nombre de billets pour une date donnée
     *
     * @param dateVisite date à chercher
     * @return le nombre de billets
     */
    int countAllByDateVisiteAndEtat(LocalDate dateVisite, EtatBillet etat);

    /**
     * Recherche les billets appartenant à un utilisateur
     *
     * @param cptId id du visiteur
     * @return une collection de billets appartenant au visiteur
     */
    Collection<Billet> findAllByCompteVisiteurId(Long cptId);
}
