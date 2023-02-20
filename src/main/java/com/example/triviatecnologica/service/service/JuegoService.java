package com.example.triviatecnologica.service.service;

import com.example.triviatecnologica.dto.UsuarioDTO;
import com.example.triviatecnologica.entity.Juego;
import com.example.triviatecnologica.entity.Opcion;
import com.example.triviatecnologica.entity.Pregunta;
import com.example.triviatecnologica.entity.Usuario;
import com.example.triviatecnologica.utility.Categoria;

import java.util.ArrayList;

public interface JuegoService {

    Categoria obtenerCategoriaAzar();
    Pregunta obtenerPreguntaAzar();

    void respuestaObtenida(Boolean rta); // setteo si contesto o mal

    void Juego();

    ArrayList<Pregunta> listarPreguntas();

    Usuario guardarUsuarioJuego(UsuarioDTO usuarioDTO);

    void settearPreguntas();

    void eliminarPregunta(Pregunta pregunta);
}
