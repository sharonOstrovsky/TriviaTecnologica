package com.example.triviatecnologica.entity;

import com.example.triviatecnologica.utility.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;

    private String opcionCorrecta;

    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", nivel=" + nivel +
                ", descripcion='" + descripcion + '\'' +
                ", opcionA='" + opcionA + '\'' +
                ", opcionB='" + opcionB + '\'' +
                ", opcionC='" + opcionC + '\'' +
                ", opcionD='" + opcionD + '\'' +
                ", opcionCorrecta='" + opcionCorrecta + '\'' +
                '}';
    }
}
