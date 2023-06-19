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
     * Récupère une attraction selon son nom
     *
     * @param nom de l'attraction
     * @return le compte s'il existe
     * @throws com.appent.miageland.utilities.exceptions.attraction.AttractionExistanteException si le compte n'existe pas
     */
    public Attraction getAttraction(String nom) {
        return this.attractionRepository.findByNom(nom).orElseThrow(() ->
                AttractionExceptionFactory.createAttractionExistanteException(nom));
    }

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

}
