package com.example.triviatecnologica.service.imp;

import com.example.triviatecnologica.dto.UsuarioDTO;
import com.example.triviatecnologica.entity.Usuario;
import com.example.triviatecnologica.repository.UsuarioRepository;
import com.example.triviatecnologica.service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
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

    @Override
    public Usuario crearUsuario() {
        return null;
    }

    @Override
    public Usuario guardarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(null,
                usuarioDTO.getNombre(),
                usuarioDTO.getEdad(),
                usuarioDTO.getTelefono(),
                usuarioDTO.getMail());

      //  System.out.println(usuario);

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario guardarUsuarioDOS(Usuario usuario) {

        System.out.println(usuario);

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

}
