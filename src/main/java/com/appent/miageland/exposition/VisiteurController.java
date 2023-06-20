package com.appent.miageland.exposition;

import com.appent.miageland.entities.Compte;
import com.appent.miageland.services.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comptes")
@AllArgsConstructor
public class VisiteurController {

    private final CompteService compteService;

    @GetMapping("login/{adresseMail}")
    public Long login(String adresseMail) {
        return this.compteService.login(adresseMail);
    }

    @PostMapping
    public Long creerVisiteur(@RequestBody Compte compte) {
        return this.compteService.creerCompteVisiteur(compte);
    }

    @DeleteMapping("/{cptId}")
    public void supprimerVisiteur(Long cptId) {
        this.compteService.supprCompteVisiteur(cptId);
    }
}
