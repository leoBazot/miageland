package com.appent.miageland.utilities.exceptions.billet;

public class DateAnnulationInvalideException extends RuntimeException {

    public DateAnnulationInvalideException() {
        super("Un billet ne peut être annulé que jusqu'a 7 jours avant la date de la viste, pas après !");
    }
}
