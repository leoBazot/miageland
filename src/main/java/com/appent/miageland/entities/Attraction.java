package com.appent.miageland.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Attraction {
    /**
     * Id de l'entité
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nom de l'attraction
     */
    @NotNull
    @Column(unique = true)
    private String nom;

    /**
     * Est-ce que l'attraction est ouverte
     */
    @NotNull
    private boolean ouvert;
}
