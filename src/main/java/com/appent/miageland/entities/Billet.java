package com.appent.miageland.entities;

import com.appent.miageland.export.EtatBillet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

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
    private Date dateVisite;

    /**
     * Visiteur ayant acheté le billet
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private CompteVisiteur compteVisiteur;

    /**
     * Prix
     */
    @NotNull
    private double prix;

    /**
     * Etat du billet
     */
    @NotNull
    private EtatBillet etat;

}