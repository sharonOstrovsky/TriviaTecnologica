package com.example.triviatecnologica.service.imp;

import com.example.triviatecnologica.entity.Usuario;
import com.example.triviatecnologica.service.service.UsuarioService;

public class UsuarioServiceImp implements UsuarioService {
    @Override
    public int obtenerNivelPorEdad(Usuario usuario) {

        if(usuario.getEdad() < 14){
            return 1;
        }else if (usuario.getEdad() >= 14 && usuario.getEdad() < 17 ) {
            return 2;
        } else if (usuario.getEdad() >= 17 ) {
            return 3;
        }
        return 0;
    }
}
