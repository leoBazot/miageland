package com.appent.miageland;

import com.appent.miageland.dao.*;
import com.appent.miageland.entities.*;
import com.appent.miageland.export.EtatBillet;
import com.appent.miageland.export.TypeEmploye;
import com.appent.miageland.utilities.SuperVision;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
@AllArgsConstructor
public class MiagelandApplication implements CommandLineRunner {

    /**
     * logger
     */
    private static final Logger logger = LogManager.getLogger(MiagelandApplication.class);

    private final CompteEmployeRepository compteEmployeRepository;

    private final CompteVisiteurRepository compteVisiteurRepository;

    private final BilletRepository billetRepository;

    private final AttractionRepository attractionRepository;

    private final JaugeRepository jaugeRepository;

    public static void main(String[] args) {
        SpringApplication.run(MiagelandApplication.class, args);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = Exception.class)
    public void run(String... args) {
        logger.info("Démarrage de l'application");

        if (this.compteEmployeRepository.count() == 0) {
            logger.info("Création du gérant....");
            var gerant = new CompteEmploye();

            gerant.setNom("Bogacki");
            gerant.setPrenom("Léo");
            gerant.setAdresseMail("admin@miageland.com");
            gerant.setTypeEmploye(TypeEmploye.GERANT);

            this.compteEmployeRepository.save(gerant);
            logger.info("Gérant créé !");


            logger.info("Création du visiteur Jean Eude....");
            var jeanEude = new CompteVisiteur();

            jeanEude.setNom("Eude");
            jeanEude.setPrenom("Jean");
            jeanEude.setAdresseMail("Jean.eude@gmail.com");
            jeanEude.setBillets(new ArrayList<>());

            this.compteVisiteurRepository.save(jeanEude);
            logger.info("Visiteur Jean Eude créé !");

            logger.info("Création du visiteur Marie Vignères....");
            var marieVigneres = new CompteVisiteur();

            marieVigneres.setNom("Vignères");
            marieVigneres.setPrenom("Marie");
            marieVigneres.setAdresseMail("Marie.vignère@gmail.com");
            marieVigneres.setBillets(new ArrayList<>());

            this.compteVisiteurRepository.save(marieVigneres);
            logger.info("Visiteur Marie Vignères créé !");

            logger.info("Création du visiteur Paul Dupont....");
            var paulDupont = new CompteVisiteur();

            paulDupont.setNom("Dupont");
            paulDupont.setPrenom("Paul");
            paulDupont.setAdresseMail("Paul.dupont@gmail.com");
            paulDupont.setBillets(new ArrayList<>());

            this.compteVisiteurRepository.save(paulDupont);
            logger.info("Visiteur Paul Dupont créé !");

            logger.info("Réservation d'un billet pour Jean Eude le 2023-08-23....");
            var billet = new Billet();

            billet.setCompteVisiteur(jeanEude);
            billet.setDateVisite(LocalDate.parse("2023-08-23"));
            billet.setEtat(EtatBillet.ATTENTE_PAIEMENT);
            billet.setPrix(SuperVision.PRIX_PAR_DEFAUT);

            this.billetRepository.save(billet);

            logger.info("Réservation d'un billet pour Marie Vignères le 2023-08-23....");
            var billet2 = new Billet();

            billet2.setCompteVisiteur(marieVigneres);
            billet2.setDateVisite(LocalDate.parse("2023-08-23"));
            billet2.setEtat(EtatBillet.ATTENTE_PAIEMENT);
            billet2.setPrix(SuperVision.PRIX_PAR_DEFAUT);

            this.billetRepository.save(billet2);

            logger.info("Réservation d'un 2eme billet pour Marie Vignères le 2023-08-23....");
            var billet3 = new Billet();

            billet3.setCompteVisiteur(marieVigneres);
            billet3.setDateVisite(LocalDate.parse("2023-08-23"));
            billet3.setEtat(EtatBillet.VALIDE);
            billet3.setPrix(SuperVision.PRIX_PAR_DEFAUT);

            this.billetRepository.save(billet3);

            logger.info("Réservation d'un billet pour Paul Dupont le 2023-08-23....");
            var billet4 = new Billet();

            billet4.setCompteVisiteur(paulDupont);
            billet4.setDateVisite(LocalDate.parse("2023-08-23"));
            billet4.setEtat(EtatBillet.ATTENTE_PAIEMENT);
            billet4.setPrix(SuperVision.PRIX_PAR_DEFAUT);

            this.billetRepository.save(billet4);

            logger.info("Réservation d'un billet pour Marie Vignères le 2024-01-01....");
            var billet5 = new Billet();

            billet5.setCompteVisiteur(marieVigneres);
            billet5.setDateVisite(LocalDate.parse("2024-01-01"));
            billet5.setEtat(EtatBillet.ATTENTE_PAIEMENT);
            billet5.setPrix(SuperVision.PRIX_PAR_DEFAUT);

            this.billetRepository.save(billet5);

            logger.info("Création d'un billet utilisé pour Marie Vignères le 2023-06-15....");
            var billet6 = new Billet();

            billet6.setCompteVisiteur(marieVigneres);
            billet6.setDateVisite(LocalDate.parse("2023-06-15"));
            billet6.setEtat(EtatBillet.UTILISE);
            billet6.setPrix(SuperVision.PRIX_PAR_DEFAUT);

            this.billetRepository.save(billet6);

            logger.info("Création d'un billet utilisé pour Jean Eude le 2023-06-15....");
            var billet7 = new Billet();

            billet7.setCompteVisiteur(jeanEude);
            billet7.setDateVisite(LocalDate.parse("2023-06-15"));
            billet7.setEtat(EtatBillet.UTILISE);
            billet7.setPrix(SuperVision.PRIX_PAR_DEFAUT);

            this.billetRepository.save(billet7);

            logger.info("Création d'un billet valide pour Jean Eude le 2023-06-22....");
            var billet8 = new Billet();

            billet8.setCompteVisiteur(jeanEude);
            billet8.setDateVisite(LocalDate.parse("2023-06-22"));
            billet8.setEtat(EtatBillet.VALIDE);
            billet8.setPrix(SuperVision.PRIX_PAR_DEFAUT);

            this.billetRepository.save(billet8);

            logger.info("Création d'une attraction ouverte : \"Tah le louping\"....");
            var looping = new Attraction();

            looping.setNom("Tah le louping");
            looping.setOuvert(true);

            this.attractionRepository.save(looping);

            logger.info("Création d'une attraction fermée : \"Aquaparc Gregory\"....");
            var aquaparc = new Attraction();

            aquaparc.setNom("Aquaparc Gregory");
            aquaparc.setOuvert(false);

            this.attractionRepository.save(aquaparc);

            logger.info("Création d'une attraction ouverte : \"Chute libre Roland garros\"....");
            var chuteLibre = new Attraction();

            chuteLibre.setNom("Chute libre Roland garros");
            chuteLibre.setOuvert(true);

            this.attractionRepository.save(chuteLibre);

            logger.info("Création d'une jauge de 4 personnes pour le 2023-08-23....");
            var jauge = new Jauge();

            jauge.setNbPlaces(5);
            jauge.setJour(LocalDate.parse("2023-08-23"));

            this.jaugeRepository.save(jauge);

            logger.info("Billets réservés !");
        }
    }
}
