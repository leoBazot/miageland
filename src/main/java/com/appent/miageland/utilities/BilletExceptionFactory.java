package com.appent.miageland.utilities;

import com.appent.miageland.utilities.exceptions.billet.BilletInexistantException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BilletExceptionFactory {

    /**
     * Crée une exception lorsqu'un billet n'existe pas pour l'id de billet donnée
     *
     * @param id du billet
     * @return BilletInexistantException
     */
    public static BilletInexistantException creerBilletInexistantException(Long id) {
        return new BilletInexistantException(id);
    }
}
