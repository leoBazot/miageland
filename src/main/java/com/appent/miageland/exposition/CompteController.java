package com.appent.miageland.exposition;

import com.appent.miageland.entities.Compte;
import com.appent.miageland.services.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comptes")
@AllArgsConstructor
public class CompteController {

    private final CompteService compteService;

    @GetMapping("login/{adresseMail}")
    public Long login(String adresseMail) {
        return this.compteService.login(adresseMail);
    }

    @PostMapping("creer")
    public Long creerCompte(@RequestBody Compte compte) {
        return this.compteService.creerCompteVisiteur(compte);
    }

}
