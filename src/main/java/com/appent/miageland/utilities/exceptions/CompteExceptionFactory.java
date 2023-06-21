package com.appent.miageland.utilities.exceptions;

import com.appent.miageland.utilities.exceptions.compte.CompteExistantException;
import com.appent.miageland.utilities.exceptions.compte.CompteInexistantException;
import com.appent.miageland.utilities.exceptions.compte.CompteNonAutoriseException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Factory permettant de créer des exceptions liées aux comptes
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompteExceptionFactory {

    /**
     * Crée une exception lorsqu'un compte existe déjà pour l'adresse mail donnée
     *
     * @param adresseMail adresse mail du compte
     */
    public static CompteExistantException createCompteExistantException(String adresseMail) {
        return new CompteExistantException(adresseMail);
    }

    /**
     * Crée une exception lorsqu'un compte n'existe pas pour l'adresse mail donnée
     *
     * @param adresseMail adresse mail du compte
     */
    public static CompteInexistantException createCompteInexistantException(String adresseMail) {
        return new CompteInexistantException(adresseMail);
    }

    /**
     * Crée une exception lorsqu'un compte n'existe pas pour l'adresse mail donnée
     *
     * @param id du compte
     */
    public static CompteInexistantException createCompteInexistantException(UUID id) {
        return new CompteInexistantException(id);
    }

    /**
     * Crée une exception lorsqu'un compte n'a pas les autorisation nécéssaires pour réaliser une opération
     *
     * @param id du compte
     * @return une exception
     */
    public static CompteNonAutoriseException createCompteNonAutoriseException(String id) {
        return new CompteNonAutoriseException(id);
    }
}
