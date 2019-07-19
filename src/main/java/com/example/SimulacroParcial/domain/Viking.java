package com.example.SimulacroParcial.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

@Data
@Entity
@ToString
public class Viking extends Person {
    private String bebedorProfesional;
}
