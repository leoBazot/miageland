package com.appent.miageland.utilities.exceptions;

import com.appent.miageland.entities.Jauge;
import com.appent.miageland.export.JaugeExport;
import com.appent.miageland.utilities.exceptions.jauge.JaugeExistanteException;
import com.appent.miageland.utilities.exceptions.jauge.JaugeInexistanteException;
import com.appent.miageland.utilities.exceptions.jauge.JaugePleineException;
import com.appent.miageland.utilities.exceptions.jauge.JaugeTropPetiteException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JaugeExceptionFactory {

    public static JaugePleineException createJaugePleineException(Jauge jauge) {
        return new JaugePleineException(jauge);
    }

    public static JaugeInexistanteException createJaugeInexistanteException(String date) {
        return new JaugeInexistanteException(date);
    }

    public static JaugeExistanteException createJaugeExistanteException(String date) {
        return new JaugeExistanteException(date);
    }

    public static JaugeTropPetiteException createJaugeTropPetiteException(JaugeExport jauge, int nbBillets) {
        return new JaugeTropPetiteException(jauge, nbBillets);
    }
}
