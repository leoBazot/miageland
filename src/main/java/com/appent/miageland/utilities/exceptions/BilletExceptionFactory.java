package com.appent.miageland.utilities.exceptions;

import com.appent.miageland.entities.Billet;
import com.appent.miageland.utilities.exceptions.billet.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Factory permettant de créer des exceptions liées aux billets
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BilletExceptionFactory {

    /**
     * Crée une exception lorsqu'un billet n'existe pas pour l'id de billet donnée
     *
     * @param id du billet
     * @return BilletInexistantException
     */
    public static BilletInexistantException createBilletInexistantException(Long id) {
        return new BilletInexistantException(id);
    }

    public static BilletInvalideException createBilletInvalideException(Billet billet) {
        return new BilletInvalideException(billet);
    }

    public static DateAnnulationInvalideException createDateAnnulationInvalideException() {
        return new DateAnnulationInvalideException();
    }

    public static DateReservationInvalideException createDateReservationInvalideException() {
        return new DateReservationInvalideException();
    }

    public static DateVisiteInvalideException createDateVisiteInvalideException(LocalDate date) {
        return new DateVisiteInvalideException(date);
    }
}
