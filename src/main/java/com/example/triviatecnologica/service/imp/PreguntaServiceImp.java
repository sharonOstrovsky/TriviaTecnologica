package com.example.triviatecnologica.service.imp;


import com.example.triviatecnologica.entity.Pregunta;
import com.example.triviatecnologica.repository.PreguntaRepository;
import com.example.triviatecnologica.service.service.PreguntaService;
import com.example.triviatecnologica.utility.Categoria;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class PreguntaServiceImp implements PreguntaService {


    PreguntaRepository preguntaRepository;

    public PreguntaServiceImp(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public ArrayList<Pregunta> settearPreguntasParaUsuario(int nivel) {
        List<Pregunta> preguntas = preguntaRepository.findAll();

        ArrayList<Pregunta> preguntasUsuario = new ArrayList<>();

        for (Pregunta pregunta: preguntas) {
            if(pregunta.getNivel() == nivel){
                preguntasUsuario.add(pregunta);
            }
        }

        return preguntasUsuario;
    }

    @Override
    public ArrayList<Pregunta> settearPreguntasParaUsuarioNivelNulo() {

        return (ArrayList<Pregunta>) preguntaRepository.findAll();

    }

    public ArrayList<Pregunta> obtenerPreguntasPorCategoria(ArrayList<Pregunta> preguntasUsuario, Categoria categoria){
        ArrayList<Pregunta> preguntasCategoria = new ArrayList<>();
       // System.out.println("Categoria: "+categoria);
        for (Pregunta pregunta: preguntasUsuario) {
            if(pregunta.getCategoria().equals(categoria)){
                preguntasCategoria.add(pregunta);

            }
        }

        return preguntasCategoria;
    }

    @Override
    public boolean esRespuestaCorrecta(String op, Pregunta pregunta) {

        if(op.equals(pregunta.getOpcionCorrecta())){
            System.out.println("La respuesta es Correcta!");
            return true;
        }
        System.out.println("La respuesta es Incorrecta! :(");
        return false;
    }
}
