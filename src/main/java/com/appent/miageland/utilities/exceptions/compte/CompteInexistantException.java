package com.appent.miageland.utilities.exceptions.compte;

public class CompteInexistantException extends RuntimeException {

    /**
     * Crée une exception lorsqu'un compte n'existe pas pour l'adresse mail donnée
     *
     * @param adresseMail adresse mail du compte
     */
    public CompteInexistantException(String adresseMail) {
        super("Aucun compte n'existe pour l'adresse mail " + adresseMail + " !");
    }

    /**
     * Crée une exception lorsqu'un compte n'existe pas pour l'id de compte donnée
     *
     * @param id du compte
     */
    public CompteInexistantException(Long id) {

        super("Aucun compte n'existe pour l'identifiant " + id + " !");
    }
}
