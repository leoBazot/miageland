package com.appent.miageland.utilities.exceptions.attraction;

public class AttractionInexistanteException extends RuntimeException {

    /**
     * Crée une exception lorsqu'une attraction existe déjà pour l'id donné
     *
     * @param attId adresse mail du compte
     */
    public AttractionInexistanteException(Long attId) {
        super("L'attraction \"" + attId + "\" n'existe pas !");
    }
}
