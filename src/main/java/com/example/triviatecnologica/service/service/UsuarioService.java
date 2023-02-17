package com.example.triviatecnologica.service.service;

import com.example.triviatecnologica.dto.UsuarioDTO;
import com.example.triviatecnologica.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UsuarioService {


    int obtenerNivelPorEdad(Usuario usuario);

    Usuario crearUsuario();

    Usuario guardarUsuario(UsuarioDTO usuarioDTO);

    Usuario guardarUsuarioDOS(Usuario usuario);

    List<Usuario> listarUsuarios();
}
