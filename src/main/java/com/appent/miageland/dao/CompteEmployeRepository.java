package com.appent.miageland.dao;

import com.appent.miageland.entities.CompteEmploye;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CompteEmployeRepository extends CrudRepository<CompteEmploye, Long> {

    Optional<CompteEmploye> findByAdresseMail(String adresseMail);
}
