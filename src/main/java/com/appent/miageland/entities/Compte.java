package com.appent.miageland.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@MappedSuperclass
@Data
public class Compte {
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

    public Long getId() {
        return null;
    }

    public void setId(Long id) {
    }
}
