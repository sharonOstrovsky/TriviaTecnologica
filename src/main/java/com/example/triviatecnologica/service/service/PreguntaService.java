package com.example.triviatecnologica.service.service;

import com.example.triviatecnologica.entity.Pregunta;
import com.example.triviatecnologica.utility.Categoria;

import java.util.ArrayList;

public interface PreguntaService {


    ArrayList<Pregunta> settearPreguntasParaUsuario(int nivel );

    ArrayList<Pregunta> settearPreguntasParaUsuarioNivelNulo();
    ArrayList<Pregunta> obtenerPreguntasPorCategoria(ArrayList<Pregunta> preguntasUsuario, Categoria categoria);

    boolean esRespuestaCorrecta(String op, Pregunta pregunta);
}
