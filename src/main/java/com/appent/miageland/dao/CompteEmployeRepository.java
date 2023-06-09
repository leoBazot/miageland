package com.appent.miageland.dao;

import com.appent.miageland.entities.CompteEmploye;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;


public interface CompteEmployeRepository extends CrudRepository<CompteEmploye, UUID> {

    /**
     * Recherche un compte employé par son adresse mail
     *
     * @param adresseMail de l'employé
     * @return l'employé recherchée
     */
    Optional<CompteEmploye> findByAdresseMail(String adresseMail);

    Collection<CompteEmploye> findAll();
}
