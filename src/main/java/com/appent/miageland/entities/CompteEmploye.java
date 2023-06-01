package com.appent.miageland.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CompteEmploye extends Compte {
    /**
     * Type d'employe
     */
    private TypeEmploye typeEmploye;
}
