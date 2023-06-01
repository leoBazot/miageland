package com.appent.miageland.exposition;

import com.appent.miageland.entities.Compte;
import com.appent.miageland.services.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comptes")
@AllArgsConstructor
public class CompteController {

    private final CompteService compteService;

    @GetMapping("login/{adresseMail}")
    public Compte login(String adresseMail) {
        // TODO
        return null;
    }
}
