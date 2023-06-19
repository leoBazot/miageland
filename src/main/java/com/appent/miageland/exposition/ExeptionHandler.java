package com.appent.miageland.exposition;

import com.appent.miageland.export.ErrorExport;
import com.appent.miageland.utilities.exceptions.attraction.AttractionExistanteException;
import com.appent.miageland.utilities.exceptions.billet.BilletInexistantException;
import com.appent.miageland.utilities.exceptions.compte.CompteExistantException;
import com.appent.miageland.utilities.exceptions.compte.CompteInexistantException;
import com.appent.miageland.utilities.exceptions.compte.CompteNonAutoriseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe de gestion des exception pour l'API via la configuration spring
 */
@ControllerAdvice
public class ExeptionHandler {

    /*
     ***************************************
     ************* ERREURS 404 *************
     ***************************************
     */

    /**
     * Erreur 404 lorsqu'un id n'est pas fournis alors que nécessaire
     * <a href="https://www.baeldung.com/spring-optional-path-variables#pathVariable-parameters">voir ici</a>
     *
     * @param exception exception throw
     * @return error 404 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ErrorExport> gererException(MissingPathVariableException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    /**
     * Erreur 404 en cas de compte inexistant dans la base
     *
     * @param exception exception throw
     * @return error 404 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(CompteInexistantException.class)
    public ResponseEntity<ErrorExport> gererException(CompteInexistantException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    /**
     * Erreur 404 en cas de billet inexistant dans la base
     *
     * @param exception exception throw
     * @return error 404 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(BilletInexistantException.class)
    public ResponseEntity<ErrorExport> gererException(BilletInexistantException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    /*
     ***************************************
     ************* ERREURS 400 *************
     ***************************************
     */

    /**
     * Erreur 400 en cas de compte déjà existant dans la base
     *
     * @param exception exception throw
     * @return error 400 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(CompteExistantException.class)
    public ResponseEntity<ErrorExport> gererException(CompteExistantException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Erreur 400 en cas de compte déjà existant dans la base
     *
     * @param exception exception throw
     * @return error 400 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(AttractionExistanteException.class)
    public ResponseEntity<ErrorExport> gererException(AttractionExistanteException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.BAD_REQUEST);
    }

    /*
     ***************************************
     ************* ERREURS 403 *************
     ***************************************
     */

    /**
     * Erreur 403 si le compte manque de droit pour réaliser une opération
     *
     * @param exception exception throw
     * @return error 403 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(CompteNonAutoriseException.class)
    public ResponseEntity<ErrorExport> gererException(CompteNonAutoriseException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.FORBIDDEN);
    }

    /*
     ***************************************
     ************* ERREURS 500 *************
     ***************************************
     */

    /**
     * Erreur 500 en cas d'autre erreur
     *
     * @param exception exception
     * @return l'erreur 500 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorExport> gereAutreException(Exception exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}