package com.example.triviatecnologica.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Juego {

    private ArrayList<Pregunta> preguntas;
    private Usuario usuario;
    private int cantPreguntasPorUsuario; //5

    private int cantCorrestas; //se inicialliza en cero
    private int cantIncorrectas; //se inicialliza en cero


}
