package com.appent.miageland.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Compte {
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

    public abstract Long getId();

    public abstract void setId(Long id);
}
