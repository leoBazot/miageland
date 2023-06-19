package com.appent.miageland.services;

import com.appent.miageland.dao.CompteEmployeRepository;
import com.appent.miageland.dao.CompteVisiteurRepository;
import com.appent.miageland.entities.Compte;
import com.appent.miageland.entities.CompteEmploye;
import com.appent.miageland.entities.CompteVisiteur;
import com.appent.miageland.utilities.CompteExceptionFactory;
import com.appent.miageland.utilities.exceptions.compte.CompteExistantException;
import com.appent.miageland.utilities.exceptions.compte.CompteInexistantException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompteService {

    private final CompteVisiteurRepository compteVisiteurRepository;
    private final CompteEmployeRepository compteEmployeRepository;


    /**
     * Récupère tout les comptes avec l'adresse mail donnée
     *
     * @param adresseMail l'adresse mail
     * @return la liste des comptes avec l'adresse mail donnée
     */
    private List<Compte> getAllCompteWithMail(String adresseMail) {
        List<Compte> comptes = new ArrayList<>();

        this.compteVisiteurRepository.findByAdresseMail(adresseMail).ifPresent(comptes::add);
        this.compteEmployeRepository.findByAdresseMail(adresseMail).ifPresent(comptes::add);

        return comptes;
    }

    /**
     * Permet de se connecter à un compte
     *
     * @param adresseMail l'adresse mail du compte
     * @return l'id du compte si le compte existe
     * @throws CompteInexistantException si le compte n'existe pas
     */
    public Long login(String adresseMail) {
        List<Compte> comptes = this.getAllCompteWithMail(adresseMail);

        if (comptes.isEmpty()) {
            throw CompteExceptionFactory.createCompteInexistantException(adresseMail);
        } // else

        return comptes.get(0).getId();
    }

    /**
     * Permet de créer un compte visiteur
     *
     * @param compte les informations du compte à créer
     * @return l'id du compte créé
     * @throws CompteExistantException si le compte existe déjà
     */
    public Long creerCompteVisiteur(Compte compte) {
        List<Compte> compteList = this.getAllCompteWithMail(compte.getAdresseMail());

        if (!compteList.isEmpty()) {
            throw CompteExceptionFactory.createCompteExistantException(compte.getAdresseMail());
        } // else

        CompteVisiteur newVisiteur = new CompteVisiteur();
        newVisiteur.setNom(compte.getNom());
        newVisiteur.setPrenom(compte.getPrenom());
        newVisiteur.setAdresseMail(compte.getAdresseMail());

        return this.compteVisiteurRepository.save(newVisiteur).getId();
    }

    /**
     * Permet de récupérer un compte visiteur selon son id
     *
     * @param id l'id du compte
     * @return le compte s'il existe
     * @throws RuntimeException si le compte n'existe pas
     */
    public Compte getVisiteur(Long id) {
        return this.compteVisiteurRepository.findById(id).orElseThrow(() ->
                CompteExceptionFactory.createCompteInexistantException(id));
    }

    /**
     * Permet de récupérer un compte employe selon son id
     *
     * @param id l'id du compte
     * @return le compte s'il existe
     * @throws RuntimeException si le compte n'existe pas
     */
    public CompteEmploye getEmploye(Long id) {
        return this.compteEmployeRepository.findById(id).orElseThrow(() ->
                CompteExceptionFactory.createCompteInexistantException(id));
    }

}
