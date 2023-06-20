package com.appent.miageland.services;

import com.appent.miageland.dao.BilletRepository;
import com.appent.miageland.dao.CompteVisiteurRepository;
import com.appent.miageland.dao.JaugeRepository;
import com.appent.miageland.entities.Billet;
import com.appent.miageland.entities.CompteVisiteur;
import com.appent.miageland.export.EtatBillet;
import com.appent.miageland.utilities.SuperVision;
import com.appent.miageland.utilities.exceptions.BilletExceptionFactory;
import com.appent.miageland.utilities.exceptions.JaugeExceptionFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

@Service
@AllArgsConstructor
public class BilletService {

    private final CompteVisiteurRepository compteVisiteurRepository;
    private final BilletRepository billetRepository;

    private final JaugeRepository jaugeRepository;

    /**
     * Valide un billet
     *
     * @param billetId du billet à valider
     * @return l'état du billet avant validation
     * @throws com.appent.miageland.utilities.exceptions.billet.BilletInexistantException si le billet n'existe pas
     * @throws com.appent.miageland.utilities.exceptions.billet.BilletInvalideException   si le billet est invalide
     */
    public EtatBillet valider(Long billetId) {
        var billet = this.billetRepository.findById(billetId).orElseThrow(() ->
                BilletExceptionFactory.createBilletInexistantException(billetId));

        if (billet.getEtat() != EtatBillet.VALIDE) {
            throw BilletExceptionFactory.createBilletInvalideException(billet);
        } // else
        billet.setEtat(EtatBillet.UTILISE);
        this.billetRepository.save(billet);
        return EtatBillet.VALIDE;
    }

    /**
     * Reserve un billet pour une date donnée
     *
     * @param visiteur   qui réserve le billet
     * @param dateVisite au format yyyy-MM-dd
     * @return le billet réservé
     */
    public Billet reserver(CompteVisiteur visiteur, String dateVisite) {
        var date = LocalDate.parse(dateVisite);

        var jauge = this.jaugeRepository.findByJour(date);

        var nbBillets = this.countBilletsReserves(date);

        if (jauge.isPresent() && nbBillets >= jauge.get().getNbPlaces()) {
            throw JaugeExceptionFactory.createJaugePleineException(jauge.get());
        } // else

        var newBillet = new Billet();
        newBillet.setEtat(EtatBillet.ATTENTE_PAIEMENT);
        newBillet.setPrix(SuperVision.PRIX_PAR_DEFAUT);
        newBillet.setDateVisite(date);
        newBillet.setCompteVisiteur(visiteur);

        var b = this.billetRepository.save(newBillet);

        visiteur.getBillets().add(b);

        this.compteVisiteurRepository.save(visiteur);

        return b;
    }

    /**
     * Donne le nombre de billets valides pour un jour donnée (Valides + Attente paiement + Utilisés)
     *
     * @param date du jour
     * @return le nombre de billets
     */
    private int countBilletsReserves(LocalDate date) {
        return this.billetRepository.countAllByDateVisiteAndEtat(date, EtatBillet.VALIDE)
                + this.billetRepository.countAllByDateVisiteAndEtat(date, EtatBillet.ATTENTE_PAIEMENT)
                + this.billetRepository.countAllByDateVisiteAndEtat(date, EtatBillet.UTILISE);

    }

    /**
     * Donne tout les billets d'un visiteur
     *
     * @param visiteur visiteur
     * @return collection des billets d'un visiteur
     */
    public Collection<Billet> getAll(CompteVisiteur visiteur) {
        return this.billetRepository.findAllByCompteVisiteur(visiteur);
    }

    /**
     * Donne le billet d'un visiteur par son id
     *
     * @param visiteur visiteur
     * @param billetId id du billet
     * @return le billet
     * @throws com.appent.miageland.utilities.exceptions.billet.BilletInexistantException si le billet n'existe pas
     */
    public Billet getBillet(CompteVisiteur visiteur, Long billetId) {
        return this.billetRepository.findByCompteVisiteurAndId(visiteur, billetId).orElseThrow(() -> {
            throw BilletExceptionFactory.createBilletInexistantException(billetId);
        });
    }

    /**
     * Valide le payement d'un billet
     *
     * @param visiteur visiteur
     * @param billetId id du billet à valider
     * @return le billet validé
     */
    public Billet payerBillet(CompteVisiteur visiteur, Long billetId) {
        var billet = getBillet(visiteur, billetId);

        if (billet.getEtat() != EtatBillet.ATTENTE_PAIEMENT) {
            throw BilletExceptionFactory.createBilletInvalideException(billet);
        } // else

        billet.setEtat(EtatBillet.VALIDE);
        billet.setDatePaye(LocalDate.now());

        return this.billetRepository.save(billet);
    }

    /**
     * Annule un billet non utilisé
     *
     * @param visiteur visiteur
     * @param billetId id du billet à annuler
     * @return le billet annulé
     * @throws com.appent.miageland.utilities.exceptions.billet.BilletInvalideException         si le billet est déjà utilisé ou annulé
     * @throws com.appent.miageland.utilities.exceptions.billet.DateAnnulationInvalideException si la date de visite est dans moins de 7 jours
     */
    public Billet annuler(CompteVisiteur visiteur, Long billetId) {
        var billet = getBillet(visiteur, billetId);

        if (billet.getEtat() == EtatBillet.UTILISE || billet.getEtat() == EtatBillet.ANNULE) {
            throw BilletExceptionFactory.createBilletInvalideException(billet);
        } // else

        if (Math.abs(ChronoUnit.DAYS.between(LocalDate.now(), billet.getDateVisite())) + 1 < 7) {
            throw BilletExceptionFactory.createDateAnnulationInvalideException();
        }

        billet.setEtat(EtatBillet.ANNULE);

        return this.billetRepository.save(billet);
    }
}
