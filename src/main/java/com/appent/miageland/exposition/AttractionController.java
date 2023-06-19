package com.appent.miageland.exposition;

import com.appent.miageland.entities.Attraction;
import com.appent.miageland.services.AttractionService;
import com.appent.miageland.services.CompteService;
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
    public Long creerAttraction(Long cptId, @RequestBody Attraction attraction) {
        return null;
    }
}
