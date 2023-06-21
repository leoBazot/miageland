package com.appent.miageland.exposition;

import com.appent.miageland.export.StatGlobales;
import com.appent.miageland.export.StatsJournalieres;
import com.appent.miageland.services.CompteService;
import com.appent.miageland.services.StatistiquesService;
import com.appent.miageland.utilities.Autorisations;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comptes/{cptId}/statistiques")
@AllArgsConstructor
public class StatistiquesController {

    private CompteService compteService;
    private StatistiquesService statistiquesService;

    @GetMapping
    public StatGlobales getStatGlobales(@PathVariable Long cptId) {
        this.compteService.verifAutorisations(cptId, Autorisations.SUPERVISER_PARC);

        return this.statistiquesService.getStatGlobales();
    }

    @GetMapping("/{date}")
    public StatsJournalieres getStatsJour(@PathVariable Long cptId, @PathVariable String date) {
        this.compteService.verifAutorisations(cptId, Autorisations.SUPERVISER_PARC);

        return this.statistiquesService.getStatsJour(date);
    }
}
