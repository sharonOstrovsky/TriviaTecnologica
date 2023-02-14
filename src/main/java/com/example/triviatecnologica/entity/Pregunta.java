package com.example.triviatecnologica.entity;

import com.example.triviatecnologica.utility.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;


@Entity
@Table(name="Pregunta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Categoria categoria;
    private int nivel; //por edad del usuario
    private String descripcion;

    @OneToMany
    private ArrayList<Opcion> opciones;

    private int opcionCorrecta;

}
