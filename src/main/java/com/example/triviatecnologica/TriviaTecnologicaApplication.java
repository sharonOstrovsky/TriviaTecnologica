package com.example.triviatecnologica;

import com.example.triviatecnologica.entity.Juego;
import com.example.triviatecnologica.entity.Pregunta;
import com.example.triviatecnologica.entity.Usuario;
import com.example.triviatecnologica.repository.PreguntaRepository;
import com.example.triviatecnologica.service.imp.JuegoServiceImp;
import com.example.triviatecnologica.service.imp.PreguntaServiceImp;
import com.example.triviatecnologica.service.imp.UsuarioServiceImp;
import com.example.triviatecnologica.service.service.JuegoService;
import com.example.triviatecnologica.service.service.PreguntaService;
import com.example.triviatecnologica.service.service.UsuarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TriviaTecnologicaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TriviaTecnologicaApplication.class, args);


	//	PreguntaService preguntaService = new PreguntaServiceImp(repository);
	//	UsuarioService usuarioService = new UsuarioServiceImp();


	//	JuegoService juegoService = new JuegoServiceImp(preguntaService, usuarioService);

	//	juegoService.Juego();

	//	System.out.println("juego terminado");


	}

}
