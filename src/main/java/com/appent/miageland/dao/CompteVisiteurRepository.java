package com.appent.miageland.dao;

import com.appent.miageland.entities.CompteVisiteur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;


public interface CompteVisiteurRepository extends CrudRepository<CompteVisiteur, UUID> {

    /**
     * Recherche un compte visiteur par son adresse mail
     *
     * @param adresseMail du visiteur
     * @return le visiteur recherchée
     */
    Optional<CompteVisiteur> findByAdresseMail(String adresseMail);
}
