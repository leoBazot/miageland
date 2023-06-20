package com.appent.miageland.export;

public enum EtatBillet {
    /**
     * Billet valide
     */
    VALIDE,

    /**
     * Billet annulé
     */
    ANNULE,

    /**
     * Billet utilisé
     */
    UTILISE,

    /**
     * billet réservé mais en attente de paiement
     */
    ATTENTE_PAIEMENT
}
