package com.appent.miageland.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Jauge {

    @Id
    @GeneratedValue // default = AUTO
    private Long id;

    @NotNull
    @Column(unique = true)
    private LocalDate jour;

    @NotNull
    private int nbPlaces;

}
