package com.appent.miageland.utilities.exceptions.compte;

public class MailInvalideException extends RuntimeException {

    public MailInvalideException(String adresseMail) {
        super("L'adresse mail " + adresseMail + " n'est pas valide !\n" +
                "Elle doit être de la forme : exemple@domaine.machin\n" +
                "(ex : fred@chaudcouriel.org)");
    }
}
