package com.appent.miageland.exposition;

import com.appent.miageland.entities.Billet;
import com.appent.miageland.export.EtatBillet;
import com.appent.miageland.services.BilletService;
import com.appent.miageland.services.CompteService;
import com.appent.miageland.utilities.Autorisations;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comptes/{cptId}/billets")
@AllArgsConstructor()
public class BilletController {

    private final CompteService compteService;
    private final BilletService billetService;


    @GetMapping("{billetId}/valider")
    public EtatBillet validerBillet(Long cptId, Long billetIdid) {
        this.compteService.verifAutorisations(cptId, Autorisations.VALIDER_BILLET);

        return this.billetService.valider(billetIdid);
    }

    @PostMapping("/reserver")
    public Billet reserverBillet(Long cptId, @RequestBody String dateVisite) {
        var visiteur = this.compteService.getVisiteur(cptId);

        return this.billetService.reserver(visiteur, dateVisite);
    }
}
