package com.example.SimulacroParcial.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

@Data
@Entity
@ToString
public class Spartan extends Person  {
    private String toleranciaExtra;
}
