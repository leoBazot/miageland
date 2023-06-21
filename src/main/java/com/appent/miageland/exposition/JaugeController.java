package com.appent.miageland.exposition;

import com.appent.miageland.entities.Jauge;
import com.appent.miageland.export.JaugeExport;
import com.appent.miageland.services.CompteService;
import com.appent.miageland.services.JaugeService;
import com.appent.miageland.utilities.Autorisations;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/comptes/{cptId}/jauges")
@AllArgsConstructor
public class JaugeController {

    private final CompteService compteService;

    private final JaugeService jaugeService;

    @GetMapping
    public Collection<Jauge> getAllJauges(@PathVariable String cptId) {
        this.compteService.verifAutorisations(cptId, Autorisations.SUPERVISER_PARC);

        return this.jaugeService.getAll();
    }

    @GetMapping("/{date}")
    public JaugeExport getJaugebyDate(@PathVariable String cptId, @PathVariable String date) {
        this.compteService.verifAutorisations(cptId, Autorisations.SUPERVISER_PARC);

        return this.jaugeService.getByDate(date);
    }

    @PostMapping
    public JaugeExport createJauge(@PathVariable String cptId, @RequestBody JaugeExport jauge) {
        this.compteService.verifAutorisations(cptId, Autorisations.SUPERVISER_PARC);

        return this.jaugeService.create(jauge);
    }
}
