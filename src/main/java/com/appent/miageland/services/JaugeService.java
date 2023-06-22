package com.appent.miageland.services;

import com.appent.miageland.dao.BilletRepository;
import com.appent.miageland.dao.JaugeRepository;
import com.appent.miageland.entities.Jauge;
import com.appent.miageland.export.EtatBillet;
import com.appent.miageland.export.JaugeExport;
import com.appent.miageland.utilities.exceptions.JaugeExceptionFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
@AllArgsConstructor
public class JaugeService {

    private JaugeRepository jaugeRepository;

    private BilletRepository billetRepository;

    /**
     * Récupère toutes les jauges existantes
     *
     * @return une collection de jauges
     */
    public Collection<Jauge> getAll() {
        return this.jaugeRepository.findAll();
    }

    /**
     * Récupère les jauges pour un jour donné
     *
     * @param date du jour
     * @return une jauge
     * @throws com.appent.miageland.utilities.exceptions.jauge.JaugeInexistanteException si aucune jauge n'a été trouvée pour la date donnée
     */
    public JaugeExport getByDate(String date) {
        var d = LocalDate.parse(date);

        var jauge = this.jaugeRepository.findByJour(d).orElseThrow(
                () -> JaugeExceptionFactory.createJaugeInexistanteException(date));

        return new JaugeExport(jauge.getJour().toString(), jauge.getNbPlaces());
    }

    /**
     * Crée une jauge
     *
     * @param jauge à créer
     * @return la jauge créée
     * @throws com.appent.miageland.utilities.exceptions.jauge.JaugeExistanteException si la jauge existe deja pour la date donnée
     */
    public JaugeExport create(JaugeExport jauge) {
        var date = LocalDate.parse(jauge.getJour());
        if (this.jaugeRepository.findByJour(date).isPresent()) {
            throw JaugeExceptionFactory.createJaugeExistanteException(jauge.getJour());
        }

        var nbBillets = this.billetRepository.countAllByEtatAndDateVisite(EtatBillet.VALIDE, date)
                + this.billetRepository.countAllByEtatAndDateVisite(EtatBillet.ATTENTE_PAIEMENT, date);

        if (nbBillets > jauge.getNbPlaces()) {
            throw JaugeExceptionFactory.createJaugeTropPetiteException(jauge, nbBillets);
        }

        var newJauge = new Jauge();
        newJauge.setJour(date);
        newJauge.setNbPlaces(jauge.getNbPlaces());

        var res = this.jaugeRepository.save(newJauge);

        return new JaugeExport(res.getJour().toString(), res.getNbPlaces());
    }
}
