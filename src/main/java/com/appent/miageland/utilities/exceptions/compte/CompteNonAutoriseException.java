package com.appent.miageland.utilities.exceptions.compte;

public class CompteNonAutoriseException extends RuntimeException {

    /**
     * Crée une exception lorsqu'un compte n'est pas autorisé à réaliser une action
     */
    public CompteNonAutoriseException(String id) {
        super("Le compte : \"" + id + "\" n'a pas les autorisations nécéssaires pour cette opération !");
    }
}
