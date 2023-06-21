package com.appent.miageland.export;

import lombok.Data;

@Data
public class StatGlobales {
    private double recettesTotale;

    private double recetteTotaleEspere;

    private int nbBilletsVendu;

    private double nbBilletsVenduMoyen;

    /**
     * nombre de billets en attente de paiement
     */
    private int nbBilletsReserves;


    private double nbVisiteurMoyen;

    private int nbVisiteurTotal;

    private double nbVisiteMoyParVisiteur;
}
