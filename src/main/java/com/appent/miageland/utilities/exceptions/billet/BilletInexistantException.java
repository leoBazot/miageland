package com.appent.miageland.utilities.exceptions.billet;

public class BilletInexistantException extends RuntimeException {

    /**
     * Crée une exception lorsqu'un compte n'existe pas pour l'id de compte donnée
     *
     * @param id du compte
     */
    public BilletInexistantException(Long id) {
        super("Aucun billet n'existe pour l'identifiant " + id + " !");
    }
}
