package com.appent.miageland.services;

import com.appent.miageland.dao.BilletRepository;
import com.appent.miageland.export.EtatBillet;
import com.appent.miageland.utilities.exceptions.BilletExceptionFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BilletService {

    private final BilletRepository billetRepository;

    /**
     * Valide un billet
     *
     * @param billetId du billet à valider
     * @return l'état du billet avant validation
     * @throws com.appent.miageland.utilities.exceptions.billet.BilletInexistantException si le billet n'existe pas
     */
    public EtatBillet validerBillet(Long billetId) {
        var billet = this.billetRepository.findById(billetId).orElseThrow(() ->
                BilletExceptionFactory.createBilletInexistantException(billetId));

        if (billet.getEtat() == EtatBillet.VALIDE) {
            billet.setEtat(EtatBillet.UTILISE);
            this.billetRepository.save(billet);
            return EtatBillet.VALIDE;
        }

        return billet.getEtat();
    }

}
