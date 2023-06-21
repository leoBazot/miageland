package com.appent.miageland;

import com.appent.miageland.dao.CompteEmployeRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@AllArgsConstructor
public class MiagelandApplication implements CommandLineRunner {

    /**
     * logger
     */
    private static Logger logger = LogManager.getLogger(MiagelandApplication.class);

    private final CompteEmployeRepository compteEmployeRepository;

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
    }
}
