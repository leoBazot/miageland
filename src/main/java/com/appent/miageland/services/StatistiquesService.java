package com.appent.miageland.services;

import com.appent.miageland.dao.BilletRepository;
import com.appent.miageland.entities.Billet;
import com.appent.miageland.entities.CompteVisiteur;
import com.appent.miageland.export.EtatBillet;
import com.appent.miageland.export.StatGlobales;
import com.appent.miageland.export.StatsJournalieres;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StatistiquesService {

    private BilletRepository billetRepository;

    /**
     * Recettes en euro des billets utilisés
     *
     * @return la somme des prix des billets utilisés
     */
    private double getRecettesTotale() {
        var billets = this.billetRepository.findAllByEtat(EtatBillet.UTILISE);

        double recette = 0.0;
        for (var b : billets) {
            recette += b.getPrix();
        }

        return recette;
    }

    /**
     * Recettes en euro des billets utilisés, validés et en attente de paiement
     *
     * @return la somme des prix des billets qui n'ont aps été annulés
     */
    private double getRecettesTotaleEspere() {
        var billets = this.billetRepository.findAllByEtat(EtatBillet.UTILISE);
        billets.addAll(this.billetRepository.findAllByEtat(EtatBillet.VALIDE));
        billets.addAll(this.billetRepository.findAllByEtat(EtatBillet.ATTENTE_PAIEMENT));

        double recette = 0.0;
        for (var b : billets) {
            recette += b.getPrix();
        }

        return recette;
    }

    /**
     * Récupère le nombre de billets ayant été payés
     *
     * @return nombre de billets vendu
     */
    private int getNbBilletsVendus() {
        return this.billetRepository.countAllByEtat(EtatBillet.UTILISE)
                + this.billetRepository.countAllByEtat(EtatBillet.VALIDE);
    }

    /**
     * @return nombre de billets vendu par jours
     */
    private double getNbBilletsVenduMoyen() {
        var billets = this.billetRepository.findAllByEtat(EtatBillet.UTILISE);
        billets.addAll(this.billetRepository.findAllByEtat(EtatBillet.VALIDE));

        // convertion en double pour la division
        double nbVisites = billets.size();
        double nbDates = this.countDatesDiff(billets);

        return nbVisites / nbDates;
    }

    /**
     * compte le nombre de dates de visite différentes pour les billets donnés
     *
     * @param billets liste de billets
     * @return le nombre de dates différentes
     */
    private double countDatesDiff(List<Billet> billets) {
        List<LocalDate> dates = new ArrayList<>();

        for (var b : billets) {
            if (!dates.contains(b.getDateVisite())) {
                dates.add(b.getDateVisite());
            }
        }

        return dates.size();
    }

    /**
     * @return nombre de visiteur moyen par jours
     */
    private double getNbVisiteurMoyen() {
        var billets = this.billetRepository.findAllByEtat(EtatBillet.UTILISE);

        // convertion en double pour la division
        double nbVisites = billets.size();
        double nbDates = countDatesDiff(billets);

        return nbVisites / nbDates;
    }


    private double getNbVisiteMoyParVisiteur() {
        var billets = this.billetRepository.findAllByEtat(EtatBillet.UTILISE);
        List<CompteVisiteur> visiteurs = new ArrayList<>();

        for (var b : billets) {
            if (!visiteurs.contains(b.getCompteVisiteur())) {
                visiteurs.add(b.getCompteVisiteur());
            }
        }

        // convertion en double pour la division
        double nbVisites = billets.size();
        double nbVisiteur = visiteurs.size();

        return nbVisites / nbVisiteur;
    }


    /**
     * Récupère les statistiques globales du parc
     *
     * @return une synthèse des statistiques globales du parc
     */
    public StatGlobales getStatGlobales() {
        var stats = new StatGlobales();

        stats.setRecettesTotale(this.getRecettesTotale());

        stats.setRecetteTotaleEspere(this.getRecettesTotaleEspere());

        stats.setNbBilletsVendu(this.getNbBilletsVendus());

        stats.setNbBilletsVenduMoyen(this.getNbBilletsVenduMoyen());

        stats.setNbBilletsReserves(this.billetRepository.countAllByEtat(EtatBillet.ATTENTE_PAIEMENT));

        stats.setNbVisiteurMoyen(this.getNbVisiteurMoyen());

        stats.setNbVisiteurTotal(this.billetRepository.countAllByEtat(EtatBillet.UTILISE));

        stats.setNbVisiteMoyParVisiteur(this.getNbVisiteMoyParVisiteur());

        return stats;
    }

    private double getRecettesJour(LocalDate date) {
        var billets = this.billetRepository.findAllByEtatAndDateVisite(EtatBillet.UTILISE, date);

        double recette = 0.0;
        for (var b : billets) {
            recette += b.getPrix();
        }

        return recette;
    }

    /**
     * Récupère le nombre de billets ayant été payés
     *
     * @return nombre de billets vendu
     */
    private int getNbBilletsVendusJour(LocalDate date) {
        return this.billetRepository.countAllByEtatAndDateVisite(EtatBillet.UTILISE, date)
                + this.billetRepository.countAllByEtatAndDateVisite(EtatBillet.VALIDE, date);
    }

    /**
     * Récupère les statistiques par date du parc
     *
     * @param date à laquelle on veut récupérer les statistiques
     * @return statistiques du jour souhaité
     */
    public StatsJournalieres getStatsJour(String date) {
        var stats = new StatsJournalieres();

        var dateParse = LocalDate.parse(date);

        stats.setRecettes(this.getRecettesJour(dateParse));

        stats.setNbBilletsVendu(this.getNbBilletsVendusJour(dateParse));

        return stats;
    }
}
