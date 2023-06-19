package com.appent.miageland.utilities.exceptions.attraction;

public class AttractionExistanteException extends RuntimeException {
    public AttractionExistanteException(String nom) {
        super("L'attraction \"" + nom + "\" existe déjà !");
    }
}
