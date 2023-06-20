package com.appent.miageland.utilities.exceptions.billet;

import com.appent.miageland.entities.Billet;

public class BilletInvalideException extends RuntimeException {

    public BilletInvalideException(Billet billet) {
        super("le billet est : " + billet.getEtat());
    }
}
