package com.appent.miageland.exposition;

import com.appent.miageland.entities.Attraction;
import com.appent.miageland.services.AttractionService;
import com.appent.miageland.services.CompteService;
import com.appent.miageland.utilities.Autorisations;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comptes/{cptId}/attractions")
@AllArgsConstructor
public class GestionAttractionController {

    private final CompteService compteService;
    private final AttractionService attractionService;


    @PostMapping
    public Attraction creerAttraction(@PathVariable String cptId, @RequestBody String nomAttraction) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_ATTRACTION);

        return this.attractionService.creeAttraction(nomAttraction);
    }

    @DeleteMapping("/{attId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimerAttraction(@PathVariable String cptId, @PathVariable Long attId) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_ATTRACTION);

        this.attractionService.supprimmerAttraction(attId);
    }

    @PutMapping("/{attId}/ouvrir")
    public void ouvrirAttraction(@PathVariable String cptId, @RequestBody Attraction attraction) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_ATTRACTION);

        this.attractionService.ouvrir(attraction);
    }

    @PutMapping("/{attId}/fermer")
    public void fermerAttraction(@PathVariable String cptId, @RequestBody Attraction attraction) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_ATTRACTION);

        this.attractionService.fermer(attraction);
    }
}
