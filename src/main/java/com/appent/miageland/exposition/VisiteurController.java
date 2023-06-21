package com.appent.miageland.exposition;

import com.appent.miageland.export.CompteExport;
import com.appent.miageland.services.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comptes")
@AllArgsConstructor
public class VisiteurController {

    private final CompteService compteService;

    @GetMapping("login/{adresseMail}")
    public CompteExport login(@PathVariable String adresseMail) {
        return this.compteService.login(adresseMail);
    }

    @PostMapping
    public CompteExport creerVisiteur(@RequestBody CompteExport compte) {
        return this.compteService.creerCompteVisiteur(compte);
    }

    @DeleteMapping("/{cptId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimerVisiteur(@PathVariable String cptId) {
        this.compteService.supprCompteVisiteur(cptId);
    }
}
