package com.example.triviatecnologica.service.service;

import com.example.triviatecnologica.entity.Juego;
import com.example.triviatecnologica.entity.Opcion;
import com.example.triviatecnologica.entity.Pregunta;
import com.example.triviatecnologica.utility.Categoria;

public interface JuegoService {

    Categoria obtenerCategoriaAzar();
    Pregunta obtenerPreguntaAzar();

    void respuestaObtenida(Boolean rta); // setteo si contesto o mal

    void Juego();



    void settearPreguntas();
}
