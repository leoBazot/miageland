package com.appent.miageland.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CompteVisiteur extends Compte {
    /**
     * Billets du visiteur
     */
    @OneToMany(mappedBy = "compteVisiteur")
    private List<Billet> billets;
}
