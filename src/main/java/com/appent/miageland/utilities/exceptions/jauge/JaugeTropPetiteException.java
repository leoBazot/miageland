package com.appent.miageland.utilities.exceptions.jauge;

import com.appent.miageland.export.JaugeExport;

public class JaugeTropPetiteException extends RuntimeException {

    public JaugeTropPetiteException(JaugeExport jauge, int nbBillets) {
        super("La jauge du " + jauge.getJour() + " est trop petite pour accueillir les " + nbBillets + " billets déjà existants ");
    }
}
