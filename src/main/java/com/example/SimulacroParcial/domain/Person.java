package com.example.SimulacroParcial.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private String apellido;
}
