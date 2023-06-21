package com.appent.miageland.utilities.exceptions.billet;

import java.time.LocalDate;

public class DateVisiteInvalideException extends RuntimeException {

    public DateVisiteInvalideException(LocalDate dateVisite) {
        super("La billet n'est pas pour aujourd'hui mais pour le " + dateVisite.toString() + " !");
    }
}
