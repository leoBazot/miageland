package com.appent.miageland;

import com.appent.miageland.dao.CompteEmployeRepository;
import com.appent.miageland.dao.CompteVisiteurRepository;
import com.appent.miageland.entities.CompteVisiteur;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@SpringBootApplication
@AllArgsConstructor
public class MiagelandApplication implements CommandLineRunner {

    /**
     * logger
     */
    private static Logger logger = LogManager.getLogger(MiagelandApplication.class);

    private final CompteEmployeRepository compteEmployeRepository;

    private final CompteVisiteurRepository compteVisiteurRepository;

    public static void main(String[] args) {
        SpringApplication.run(MiagelandApplication.class, args);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = Exception.class)
    public void run(String... args) throws Exception {
        logger.info("Démarrage de l'application");

/*
        logger.info("Création du gérant....");
        var gerant = new CompteEmploye();

        gerant.setNom("Bogacki");
        gerant.setPrenom("Léo");
        gerant.setAdresseMail("admin@miageland.com");
        gerant.setTypeEmploye(TypeEmploye.GERANT);

        this.compteEmployeRepository.save(gerant);
        logger.info("Gérant créé !");
*/

        logger.info("Création d'un visiteur....");
        var visiteur = new CompteVisiteur();

        visiteur.setNom("Eude");
        visiteur.setPrenom("Jean");
        visiteur.setAdresseMail("Jean.eude@gmail.com");
        visiteur.setBillets(new ArrayList<>());
    }
}
