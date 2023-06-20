package com.appent.miageland.utilities.exceptions.jauge;

import com.appent.miageland.entities.Jauge;

public class JaugePleineException extends RuntimeException {
    public JaugePleineException(Jauge jauge) {
        super("Aucune place restante pour le \"" + jauge.getJour() + "\" !!!");
    }
}
