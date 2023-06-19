package com.appent.miageland.exposition;

import com.appent.miageland.entities.Attraction;
import com.appent.miageland.services.AttractionService;
import com.appent.miageland.services.CompteService;
import com.appent.miageland.utilities.Autorisations;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/comptes/{cptId}/attractions")
@AllArgsConstructor()
public class AttractionController {

    private final CompteService compteService;
    private final AttractionService attractionService;


    @PostMapping("/creer")
    public Attraction creerAttraction(Long cptId, @RequestBody String nomAttraction) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_ATTRACTION);

        return this.attractionService.creeAttraction(nomAttraction);
    }

    @DeleteMapping("/{attId}")
    public void supprimerAttraction(Long cptId, Long attId) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_ATTRACTION);

        this.attractionService.supprimmerAttraction(attId);
    }

    @PutMapping("/{attId}/ouvrir")
    public void ourvrirAttraction(Long cptId, @RequestBody Attraction attraction) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_ATTRACTION);

        this.attractionService.ouvrir(attraction);
    }

    @PutMapping("/{attId}/fermer")
    public void fermerAttraction(Long cptId, @RequestBody Attraction attraction) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_ATTRACTION);

        this.attractionService.fermer(attraction);
    }
}
