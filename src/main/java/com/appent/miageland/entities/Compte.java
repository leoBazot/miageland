package com.appent.miageland.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public abstract class Compte {

    /**
     * Id de l'entité
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nom du compte
     */
    @NotNull
    private String nom;

    /**
     * Prenom du compte
     */
    @NotNull
    private String prenom;

    /**
     * Adresse mail du compte
     */
    @NotNull
    @Column(unique = true)
    private String adresseMail;
}
