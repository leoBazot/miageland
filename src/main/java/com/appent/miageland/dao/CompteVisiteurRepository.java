package com.appent.miageland.dao;

import com.appent.miageland.entities.CompteVisiteur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CompteVisiteurRepository extends CrudRepository<CompteVisiteur, Long> {

    /**
     * Recherche un compte visiteur par son adresse mail
     *
     * @param adresseMail du visiteur
     * @return le visiteur recherchée
     */
    Optional<CompteVisiteur> findByAdresseMail(String adresseMail);
}
