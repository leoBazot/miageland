package com.appent.miageland.utilities.exceptions.jauge;

public class JaugeExistanteException extends RuntimeException {
    public JaugeExistanteException(String date) {
        super("Une jauge existe déjà pour le " + date + " !");
    }
}
