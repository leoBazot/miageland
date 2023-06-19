package com.appent.miageland.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class CompteVisiteur extends Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Billets du visiteur
     */
    @OneToMany(mappedBy = "compteVisiteur")
    private List<Billet> billets;
}
