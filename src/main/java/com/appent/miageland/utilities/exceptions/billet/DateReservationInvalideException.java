package com.appent.miageland.utilities.exceptions.billet;

public class DateReservationInvalideException extends RuntimeException {

    public DateReservationInvalideException() {
        super("La date de réservation est antèrieure à la date d'aujourd'hui !");
    }
}
