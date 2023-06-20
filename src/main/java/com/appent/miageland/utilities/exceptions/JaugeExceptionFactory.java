package com.appent.miageland.utilities.exceptions;

import com.appent.miageland.entities.Jauge;
import com.appent.miageland.utilities.exceptions.jauge.JaugePleineException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JaugeExceptionFactory {

    public static JaugePleineException createJaugePleineException(Jauge jauge) {
        return new JaugePleineException(jauge);
    }
}
