package com.appent.miageland.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class CompteVisiteur extends Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Billets du visiteur
     */
    @OneToMany(mappedBy = "compteVisiteur")
    private List<Billet> billets;
}
