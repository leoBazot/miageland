package com.appent.miageland.utilities.exceptions;

import com.appent.miageland.utilities.exceptions.attraction.AttractionExistanteException;
import com.appent.miageland.utilities.exceptions.attraction.AttractionInexistanteException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Factory permettant de créer des exceptions liées aux attractions
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AttractionExceptionFactory {

    public static AttractionExistanteException createAttractionExistanteException(String nom) {
        return new AttractionExistanteException(nom);
    }

    public static AttractionInexistanteException createAttractionInexistanteException(Long attId) {
        return new AttractionInexistanteException(attId);
    }
}
