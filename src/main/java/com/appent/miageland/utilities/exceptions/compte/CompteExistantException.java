package com.appent.miageland.utilities.exceptions.compte;

public class CompteExistantException extends RuntimeException {

    /**
     * Crée une exception lorsqu'un compte existe déjà pour l'adresse mail donnée
     *
     * @param adresseMail adresse mail du compte
     */
    public CompteExistantException(String adresseMail) {
        super("Un compte existe déjà pour l'adresse mail " + adresseMail + " !");
    }
}
