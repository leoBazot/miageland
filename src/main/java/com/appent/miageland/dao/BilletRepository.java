package com.appent.miageland.dao;

import com.appent.miageland.entities.Billet;
import com.appent.miageland.entities.CompteVisiteur;
import com.appent.miageland.export.EtatBillet;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface BilletRepository extends CrudRepository<Billet, Long> {

    /**
     * Recherche d'un billet par son id
     *
     * @param visiteur visiteur
     * @param billetId l'id du billet
     * @return le billet
     */
    Optional<Billet> findByCompteVisiteurAndId(CompteVisiteur visiteur, Long billetId);

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
     * @param visiteur visiteur
     * @return une collection de billets appartenant au visiteur
     */
    Collection<Billet> findAllByCompteVisiteur(CompteVisiteur visiteur);
}
