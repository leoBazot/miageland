package com.appent.miageland.exposition;

import com.appent.miageland.entities.Attraction;
import com.appent.miageland.services.AttractionService;
import com.appent.miageland.services.CompteService;
import com.appent.miageland.utilities.Autorisations;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
