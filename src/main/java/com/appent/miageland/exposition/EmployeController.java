package com.appent.miageland.exposition;

import com.appent.miageland.export.CompteEmployeExport;
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
    public Collection<CompteEmployeExport> getAllEmploye(@PathVariable String cptId) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_PERSONNEL);

        return this.compteService.getAllEmployes();
    }

    @PostMapping
    public CompteEmployeExport creerEmploye(@PathVariable String cptId, @RequestBody CompteEmployeExport employe) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_PERSONNEL);

        return this.compteService.creerCompteEmploye(employe);
    }

    /**
     * @param cptId id du compte
     * @param eId   id de l'employe
     */
    @DeleteMapping("/{eId}")
    public void supprEmploye(@PathVariable String cptId, @PathVariable String eId) {
        this.compteService.verifAutorisations(cptId, Autorisations.GERER_PERSONNEL);

        this.compteService.supprCompteEmploye(eId);
    }
}
