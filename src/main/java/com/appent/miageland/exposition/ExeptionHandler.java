package com.appent.miageland.exposition;

import com.appent.miageland.export.ErrorExport;
import com.appent.miageland.utilities.exceptions.attraction.AttractionExistanteException;
import com.appent.miageland.utilities.exceptions.billet.*;
import com.appent.miageland.utilities.exceptions.compte.CompteExistantException;
import com.appent.miageland.utilities.exceptions.compte.CompteInexistantException;
import com.appent.miageland.utilities.exceptions.compte.CompteNonAutoriseException;
import com.appent.miageland.utilities.exceptions.compte.MailInvalideException;
import com.appent.miageland.utilities.exceptions.jauge.JaugeExistanteException;
import com.appent.miageland.utilities.exceptions.jauge.JaugeInexistanteException;
import com.appent.miageland.utilities.exceptions.jauge.JaugePleineException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

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

    /**
     * Erreur 404 en cas de jauge inexistant dans la base
     *
     * @param exception exception throw
     * @return error 404 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(JaugeInexistanteException.class)

    public ResponseEntity<ErrorExport> gererException(JaugeInexistanteException exception) {
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

    /**
     * Erreur 400 en cas de date mal formatée (!= "yyyy-MM-dd")
     *
     * @param exception exception throw
     * @return error 400 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ErrorExport> gererException(DateTimeParseException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Erreur 400 en cas de reservation d'un billet sur une date complète
     *
     * @param exception exception throw
     * @return error 400 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(JaugePleineException.class)
    public ResponseEntity<ErrorExport> gererException(JaugePleineException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Erreur 400 en cas de billet invalide
     *
     * @param exception exception throw
     * @return error 400 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(BilletInvalideException.class)
    public ResponseEntity<ErrorExport> gererException(BilletInvalideException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.BAD_REQUEST);
    }


    /**
     * Erreur 400 en cas de date d'annulation invalide
     *
     * @param exception exception throw
     * @return error 400 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(DateAnnulationInvalideException.class)
    public ResponseEntity<ErrorExport> gererException(DateAnnulationInvalideException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Erreur 400 en cas de jauge déjà existante
     *
     * @param exception exception throw
     * @return error 400 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(JaugeExistanteException.class)
    public ResponseEntity<ErrorExport> gererException(JaugeExistanteException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Erreur 400 en cas e reservation sur une date antèrieure à la date du jour
     *
     * @param exception exception throw
     * @return error 400 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(DateReservationInvalideException.class)
    public ResponseEntity<ErrorExport> gererException(DateReservationInvalideException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Erreur 400 en cas de billet pour une autre date qu'aujourd'hui
     *
     * @param exception exception throw
     * @return error 400 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(DateVisiteInvalideException.class)
    public ResponseEntity<ErrorExport> gererException(DateVisiteInvalideException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Erreur 400 en cas de billet pour une autre date qu'aujourd'hui
     *
     * @param exception exception throw
     * @return error 400 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(MailInvalideException.class)
    public ResponseEntity<ErrorExport> gererException(MailInvalideException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.BAD_REQUEST);
    }

    /*
     ***************************************
     ************* ERREURS 401 *************
     ***************************************
     */

    /**
     * Erreur 401 si le compte manque de droit pour réaliser une opération
     *
     * @param exception exception throw
     * @return error 403 ainsi que le type d'erreur et son message
     */
    @ExceptionHandler(CompteNonAutoriseException.class)
    public ResponseEntity<ErrorExport> gererException(CompteNonAutoriseException exception) {
        return new ResponseEntity<>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.UNAUTHORIZED);
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
