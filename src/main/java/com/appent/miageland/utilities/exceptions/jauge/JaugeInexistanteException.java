package com.appent.miageland.utilities.exceptions.jauge;

public class JaugeInexistanteException extends RuntimeException {
    public JaugeInexistanteException(String date) {
        super("Aucune jauge n'existe pour le " + date + " !");
    }
}
