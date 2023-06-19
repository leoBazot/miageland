package com.appent.miageland.services;

import com.appent.miageland.dao.BilletRepository;
import com.appent.miageland.dao.CompteEmployeRepository;
import com.appent.miageland.entities.EtatBillet;
import com.appent.miageland.utilities.BilletExceptionFactory;
import com.appent.miageland.utilities.CompteExceptionFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BilletService {

    private final CompteEmployeRepository compteEmployeRepository;
    private final BilletRepository billetRepository;

    /**
     * Valide un billet
     *
     * @param cptId    du compte validant les billets
     * @param billetId du billet à valider
     * @return l'état du billet avant validation
     * @throws com.appent.miageland.utilities.exceptions.compte.CompteNonAutoriseException si le compte n'est pas un compte employe ou s'il n'existe pas
     * @throws com.appent.miageland.utilities.exceptions.billet.BilletInexistantException  si le billet n'existe pas
     */
    public EtatBillet validerBillet(Long cptId, Long billetId) {
        this.compteEmployeRepository.findById(cptId).orElseThrow(() ->
                CompteExceptionFactory.createCompteNonAutoriseException(cptId));

        var billet = this.billetRepository.findById(billetId).orElseThrow(() ->
                BilletExceptionFactory.creerBilletInexistantException(billetId));

        if (billet.getEtat() == EtatBillet.VALIDE) {
            billet.setEtat(EtatBillet.UTILISE);
            this.billetRepository.save(billet);
            return EtatBillet.VALIDE;
        }

        return billet.getEtat();
    }

}
