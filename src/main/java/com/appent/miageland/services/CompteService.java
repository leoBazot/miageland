package com.appent.miageland.services;

import com.appent.miageland.dao.CompteEmployeRepository;
import com.appent.miageland.dao.CompteVisiteurRepository;
import com.appent.miageland.entities.Compte;
import com.appent.miageland.entities.CompteEmploye;
import com.appent.miageland.entities.CompteVisiteur;
import com.appent.miageland.export.CompteEmployeExport;
import com.appent.miageland.export.CompteExport;
import com.appent.miageland.export.TypeEmploye;
import com.appent.miageland.utilities.exceptions.CompteExceptionFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompteService {

    private final CompteVisiteurRepository compteVisiteurRepository;
    private final CompteEmployeRepository compteEmployeRepository;

    /**
     * Vérifie qu'un compte fait parti des membres autorisés à réaliser l'opération
     *
     * @param cptId     id du compte
     * @param autorises types de comptes autorisés à faire l'opération
     * @throws com.appent.miageland.utilities.exceptions.compte.CompteNonAutoriseException si le compte n'a pas les droits nécessaires
     */
    public void verifAutorisations(String cptId, List<TypeEmploye> autorises) {
        var employe = this.getEmploye(cptId);

        if (!autorises.contains(employe.getTypeEmploye())) {
            throw CompteExceptionFactory.createCompteNonAutoriseException(cptId);
        }
    }

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
     * Permet de récupérer un compte visiteur selon son id
     *
     * @param id l'id du compte
     * @return le compte s'il existe
     * @throws com.appent.miageland.utilities.exceptions.compte.CompteInexistantException si le compte n'existe pas
     */
    public CompteVisiteur getVisiteur(String id) {
        return this.compteVisiteurRepository.findById(UUID.fromString(id)).orElseThrow(() ->
                CompteExceptionFactory.createCompteInexistantException(UUID.fromString(id)));
    }

    /**
     * Permet de récupérer un compte employe selon son id
     *
     * @param id l'id du compte
     * @return le compte s'il existe
     * @throws com.appent.miageland.utilities.exceptions.compte.CompteInexistantException si le compte n'existe pas
     */
    public CompteEmploye getEmploye(String id) {
        return this.compteEmployeRepository.findById(UUID.fromString(id)).orElseThrow(() ->
                CompteExceptionFactory.createCompteInexistantException(UUID.fromString(id)));
    }

    /**
     * Permet à un gerant de lister les comptes employés
     *
     * @return une collection de comptes employé
     */
    public Collection<CompteEmployeExport> getAllEmployes() {
        Collection<CompteEmployeExport> res = new ArrayList<>();

        this.compteEmployeRepository.findAll().forEach(employe -> {
            var export = new CompteEmployeExport();
            export.setId(employe.getId().toString());
            export.setAdresseMail(employe.getAdresseMail());
            export.setNom(employe.getNom());
            export.setPrenom(employe.getPrenom());
            export.setTypeEmploye(employe.getTypeEmploye());

            res.add(export);
        });

        return res;
    }

    /**
     * Permet de se connecter à un compte
     *
     * @param adresseMail l'adresse mail du compte
     * @return l'id du compte si le compte existe
     * @throws com.appent.miageland.utilities.exceptions.compte.CompteInexistantException si le compte n'existe pas
     */
    public CompteExport login(String adresseMail) {
        List<Compte> comptes = this.getAllCompteWithMail(adresseMail);

        if (comptes.isEmpty()) {
            throw CompteExceptionFactory.createCompteInexistantException(adresseMail);
        } // else

        var cpt = comptes.get(0);

        var res = new CompteExport();

        res.setId(cpt.getId().toString());
        res.setAdresseMail(cpt.getAdresseMail());
        res.setNom(cpt.getNom());
        res.setPrenom(cpt.getPrenom());

        return res;
    }

    /**
     * Permet de créer un compte visiteur
     *
     * @param compte les informations du compte à créer
     * @return l'id du compte créé
     * @throws com.appent.miageland.utilities.exceptions.compte.CompteInexistantException si le compte existe déjà
     */
    public CompteExport creerCompteVisiteur(CompteExport compte) {
        List<Compte> compteList = this.getAllCompteWithMail(compte.getAdresseMail());

        if (!compteList.isEmpty()) {
            throw CompteExceptionFactory.createCompteExistantException(compte.getAdresseMail());
        } // else

        CompteVisiteur newVisiteur = new CompteVisiteur();
        newVisiteur.setId(null);
        newVisiteur.setNom(compte.getNom());
        newVisiteur.setPrenom(compte.getPrenom());
        newVisiteur.setAdresseMail(compte.getAdresseMail());
        newVisiteur.setBillets(new ArrayList<>());

        var cpt = this.compteVisiteurRepository.save(newVisiteur);

        var res = new CompteExport();
        res.setId(cpt.getId().toString());
        res.setAdresseMail(cpt.getAdresseMail());
        res.setNom(cpt.getNom());
        res.setPrenom(cpt.getPrenom());

        return res;
    }

    /**
     * Crée un compte employe
     *
     * @param employe les informations de l'employe à créer
     * @return le compte employe créé
     */
    public CompteEmployeExport creerCompteEmploye(CompteEmployeExport employe) {
        List<Compte> compteList = this.getAllCompteWithMail(employe.getAdresseMail());

        if (!compteList.isEmpty()) {
            throw CompteExceptionFactory.createCompteExistantException(employe.getAdresseMail());
        } // else

        var newEmploye = new CompteEmploye();
        newEmploye.setId(null);
        newEmploye.setNom(employe.getNom());
        newEmploye.setPrenom(employe.getPrenom());
        newEmploye.setAdresseMail(employe.getAdresseMail());
        newEmploye.setTypeEmploye(employe.getTypeEmploye());

        var cpt = this.compteEmployeRepository.save(newEmploye);

        var res = new CompteEmployeExport();

        res.setId(cpt.getId().toString());
        res.setAdresseMail(cpt.getAdresseMail());
        res.setNom(cpt.getNom());
        res.setPrenom(cpt.getPrenom());

        return res;
    }

    /**
     * Permet à un visiteur de supprimmer son compte
     *
     * @param id id du compte à supprimer
     */
    public void supprCompteVisiteur(String id) {
        this.compteVisiteurRepository.delete(this.getVisiteur(id));
    }

    /**
     * Permet à un gerant de supprimmer le compte d'un employe
     *
     * @param id id du compte à supprimer
     */
    public void supprCompteEmploye(String id) {
        this.compteEmployeRepository.delete(this.getEmploye(id));
    }
}
