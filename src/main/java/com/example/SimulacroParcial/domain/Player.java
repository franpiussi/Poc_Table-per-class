package com.example.SimulacroParcial.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

@Data
@Entity (name ="Player")
@ToString
public class Player extends Person{

    private int numeroCamiseta;
    private String posicion;
}
