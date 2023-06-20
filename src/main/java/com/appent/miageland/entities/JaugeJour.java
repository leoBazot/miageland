package com.appent.miageland.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class JaugeJour {

    @Id
    @GeneratedValue // default = AUTO
    private Long id;

    private Date jour;

    @NotNull
    private int jauge;

}
