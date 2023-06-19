package com.appent.miageland.dao;

import com.appent.miageland.entities.CompteVisiteur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CompteVisiteurRepository extends CrudRepository<CompteVisiteur, Long> {

    Optional<CompteVisiteur> findByAdresseMail(String adresseMail);
}
