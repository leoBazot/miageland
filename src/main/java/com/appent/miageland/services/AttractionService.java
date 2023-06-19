package com.appent.miageland.services;

import com.appent.miageland.dao.AttractionRepository;
import com.appent.miageland.entities.Attraction;
import com.appent.miageland.utilities.exceptions.AttractionExceptionFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttractionService {

    private final AttractionRepository attractionRepository;

    /**
     * Récupère une attraction à partir de son Id
     *
     * @param attId de l'attraction
     * @return le compte s'il existe
     * @throws com.appent.miageland.utilities.exceptions.attraction.AttractionExistanteException si le compte n'existe pas
     */
    public Attraction getAttraction(Long attId) {
        return this.attractionRepository.findById(attId).orElseThrow(() ->
                AttractionExceptionFactory.createAttractionInexistanteException(attId));
    }

    /**
     * Vérifie si une attraction existe
     *
     * @param nom de l'attraction
     * @return true si l'attraction existe
     * <p>
     * false si elle n'existe pas
     */
    public boolean existe(String nom) {
        return this.attractionRepository.findByNom(nom).isPresent();
    }

    /**
     * Crée une attraction et l'ajoute à la base de données si l'utilisateur en à les droits
     *
     * @param nom de l'attraction à ajouter
     * @return l'attraction tel que dans la base de données si elle est bien créée
     * @throws com.appent.miageland.utilities.exceptions.attraction.AttractionExistanteException si l'attraction existe déjà
     */
    public Attraction creeAttraction(String nom) {
        if (existe(nom)) {
            throw AttractionExceptionFactory.createAttractionExistanteException(nom);
        }

        var newAttraction = new Attraction();

        newAttraction.setNom(nom);

        newAttraction.setOuvert(true);

        return this.attractionRepository.save(newAttraction);
    }

    /**
     * Supprime l'attraction à partir de son id
     *
     * @param attId id de l'attraction
     * @throws com.appent.miageland.utilities.exceptions.attraction.AttractionInexistanteException si l'attraction n'existe pas
     */
    public void supprimmerAttraction(Long attId) {
        this.attractionRepository.delete(getAttraction(attId));
    }

    /**
     * Ouvre une attraction
     *
     * @param attraction qui doit être ouverte
     */
    public void ouvrir(Attraction attraction) {
        var res = this.getAttraction(attraction.getId());

        res.setOuvert(true);

        this.attractionRepository.save(res);
    }


    /**
     * Ferme une attraction
     *
     * @param attraction qui doit être fermée
     */
    public void fermer(Attraction attraction) {
        var res = this.getAttraction(attraction.getId());

        res.setOuvert(false);

        this.attractionRepository.save(res);
    }
}
