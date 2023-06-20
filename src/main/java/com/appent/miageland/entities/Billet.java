package com.appent.miageland.entities;

import com.appent.miageland.export.EtatBillet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Billet {
    /**
     * Id du billet
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Date de visite
     */
    @NotNull
    private LocalDate dateVisite;

    /**
     * Date ou le billet à été payé
     */
    @NotNull
    private LocalDate datePaye;

    /**
     * Visiteur ayant acheté le billet
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private CompteVisiteur compteVisiteur;

    /**
     * Prix en euro (€)
     */
    @NotNull
    private double prix;

    /**
     * Etat du billet
     */
    @NotNull
    private EtatBillet etat;

}
