package com.appent.miageland.utilities.exceptions.attraction;

public class AttractionExistanteException extends RuntimeException {

    /**
     * Crée une exception lorsqu'une attraction existe déjà pour le nom donné
     *
     * @param nom adresse mail du compte
     */
    public AttractionExistanteException(String nom) {
        super("L'attraction \"" + nom + "\" existe déjà !");
    }
}
