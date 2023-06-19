package com.appent.miageland.exposition;

import com.appent.miageland.entities.EtatBillet;
import com.appent.miageland.services.BilletService;
import com.appent.miageland.services.CompteService;
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

        return this.billetService.validerBillet(cptId, billetIdid);
    }
}
