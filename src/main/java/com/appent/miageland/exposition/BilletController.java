package com.appent.miageland.exposition;

import com.appent.miageland.export.EtatBillet;
import com.appent.miageland.services.BilletService;
import com.appent.miageland.services.CompteService;
import com.appent.miageland.utilities.Autorisations;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comptes/{cptId}/billets")
@AllArgsConstructor()
public class BilletController {

    private final CompteService compteService;
    private final BilletService billetService;


    @GetMapping("{billetId}/valider")
    public EtatBillet validerBillet(Long cptId, Long billetIdid) {
        this.compteService.verifAutorisations(cptId, Autorisations.VALIDER_BILLET);

        return this.billetService.validerBillet(billetIdid);
    }
}
