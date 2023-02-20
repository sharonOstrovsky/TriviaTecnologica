package com.example.triviatecnologica.service.imp;


import com.example.triviatecnologica.dto.UsuarioDTO;
import com.example.triviatecnologica.entity.Juego;
import com.example.triviatecnologica.entity.Pregunta;
import com.example.triviatecnologica.entity.Usuario;
import com.example.triviatecnologica.service.service.JuegoService;
import com.example.triviatecnologica.service.service.PreguntaService;
import com.example.triviatecnologica.service.service.UsuarioService;
import com.example.triviatecnologica.utility.Categoria;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Scanner;

@Service
public class JuegoServiceImp implements JuegoService {

    Juego juego = new Juego();


    PreguntaService preguntaService;

    UsuarioService usuarioService;

    public JuegoServiceImp(PreguntaService preguntaService, UsuarioService usuarioService) {
        this.preguntaService = preguntaService;
        this.usuarioService = usuarioService;
    }

    @Override
    public Categoria obtenerCategoriaAzar() {
        int numAleatorio = (int)(Math.random() * ((4 - 0) + 1)) + 0;

        switch (numAleatorio){
            case 0:
                return Categoria.geografia;
            case 1:
                return Categoria.matematica;
            case 2:
                return Categoria.tecnologia;
            case 3:
                return Categoria.conocimientoGeneral;
            case 4:
                return Categoria.entretenimiento;
        }
        return null;
    }

    @Override
    public Pregunta obtenerPreguntaAzar() {

        ArrayList<Pregunta> preguntas = preguntaService.obtenerPreguntasPorCategoria(juego.getPreguntas(), obtenerCategoriaAzar());

        int cantPreguntas = preguntas.size();

        int numAleatorio = (int)(Math.random() * ((cantPreguntas-1 - 0) + 1)) + 0;


        return preguntas.get(numAleatorio);
    }

    @Override
    public void respuestaObtenida(Boolean rta) { //rta es de la entidad opcion elegida
        if(rta){
           // juego.setCantCorrestas(juego.getCantCorrestas()+1);
            int cant = juego.getCantCorrestas()+1;
            juego.setCantCorrestas(cant);
        }else{
            juego.setCantIncorrectas(juego.getCantIncorrectas()+1);

        }
    }



    @Override
    public void Juego() {

        Scanner input  = new Scanner(System.in).useDelimiter("\n");

        juego.setCantCorrestas(0);
        juego.setCantIncorrectas(0);

        juego.setUsuario(new Usuario(null,"sharon", 16, "123", "sharon@gmail.com"));

        System.out.println(juego.getUsuario());

        settearPreguntas();

        for(int i = 0; i < 5; i++){
            Pregunta pregunta = obtenerPreguntaAzar();
            System.out.println(pregunta.getCategoria());
            System.out.println(pregunta.getDescripcion());
            System.out.println("A. "+pregunta.getOpcionA());
            System.out.println("B. "+pregunta.getOpcionB());
            System.out.println("C. "+pregunta.getOpcionC());
            System.out.println("D. "+pregunta.getOpcionD());
            //segun la respuesta
            //nos falta un metodo que nos diga que se obtuvo desde el front
            String rta = input.nextLine();
            respuestaObtenida(preguntaService.esRespuestaCorrecta(rta,pregunta));

            eliminarPregunta(pregunta);

        }

        System.out.println("Respuestas Incorrectas  "+juego.getCantIncorrectas());
        System.out.println("Respuestas Correctas "+juego.getCantCorrestas());

        input.close();
    }

    @Override
    public Usuario guardarUsuarioJuego(UsuarioDTO usuarioDTO){
        Usuario usuario= usuarioService.guardarUsuario(usuarioDTO);
        juego.setUsuario(usuario);
        return usuario;
    }

    @Override
    public ArrayList<Pregunta> listarPreguntas(){


        settearPreguntas();

        ArrayList<Pregunta> preguntas = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Pregunta pregunta = obtenerPreguntaAzar();
            preguntas.add(pregunta);

            eliminarPregunta(pregunta);

        }
        return preguntas;
    }



    @Override
    public void eliminarPregunta(Pregunta pregunta){

        ArrayList<Pregunta> preguntas = juego.getPreguntas();

        preguntas.remove(pregunta);

        juego.setPreguntas(preguntas);
    }

    @Override
    public void settearPreguntas() {

        int nivel = usuarioService.obtenerNivelPorEdad(juego.getUsuario());
        if(nivel == 0){
            juego.setPreguntas(preguntaService.settearPreguntasParaUsuarioNivelNulo());
        }else{
            juego.setPreguntas(preguntaService.settearPreguntasParaUsuario(nivel));
        }


    }


}
