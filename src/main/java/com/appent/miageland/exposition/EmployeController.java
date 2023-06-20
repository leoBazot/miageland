package com.appent.miageland.exposition;

import com.appent.miageland.entities.CompteEmploye;
import com.appent.miageland.services.CompteService;
import com.appent.miageland.utilities.Autorisations;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/comptes/{cptId}/employes")
@AllArgsConstructor
public class EmployeController {

    private final CompteService compteService;

    @GetMapping
    public Collection<CompteEmploye> getAllEmploye(Long cptId) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_PERSONNEL);

        return this.compteService.getAllEmployes();
    }

    @PostMapping
    public CompteEmploye creerEmploye(Long cptId, @RequestBody CompteEmploye employe) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_PERSONNEL);

        return this.compteService.creerCompteEmploye(employe);
    }
}
