package com.appent.miageland.dao;

import com.appent.miageland.entities.CompteVisiteur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompteVisiteurRepositoryTest {
    @Autowired
    CompteVisiteurRepository compteVisiteurRepository;

    @Test
    void findCompteByAdresseMail() {
        assertNotNull(this.compteVisiteurRepository);

        String mail = "test@mail.fr";

        var compte = new CompteVisiteur();

        compte.setAdresseMail(mail);

        var res = this.compteVisiteurRepository.save(compte);

        assertNotNull(res.getId());

        var found = this.compteVisiteurRepository.findByAdresseMail(mail);

        found.ifPresentOrElse(visiteur -> {
            assertEquals(res, visiteur);
        }, Assertions::fail);

        found = this.compteVisiteurRepository.findByAdresseMail("pasunmail");

        assertFalse(found.isPresent());
    }
}
