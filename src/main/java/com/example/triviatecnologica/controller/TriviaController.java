package com.example.triviatecnologica.controller;

import com.example.triviatecnologica.dto.UsuarioDTO;
import com.example.triviatecnologica.entity.Usuario;
import com.example.triviatecnologica.repository.UsuarioRepository;
import com.example.triviatecnologica.service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/juego")
public class TriviaController {

    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    public TriviaController(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/probando")
    public String hola(){
        return "probando";
    }

    @ModelAttribute("usuario")
    public UsuarioDTO retornarNuevoUserDTO(){
        return new UsuarioDTO();
    }

    @PostMapping("/registro")
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioDTO usuarioDTO){
            usuarioService.guardarUsuario(usuarioDTO);
      //  System.out.println(usuarioDTO);
        return "redirect:/registro?exito";
    }


    @GetMapping("/usuarios")
    public List<Usuario> listarTodasLosUsuarios(){
        return usuarioService.listarUsuarios();
          //retorna un html comidas
    }

    @PostMapping("/registroUsuarios")
    public ResponseEntity<Usuario> create(@RequestBody UsuarioDTO usuarioDTO, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("Content-Type"));

        if (usuarioDTO.getId() != null) { //quiere decir que existe el id y por lo tanto no es una creacion

            return ResponseEntity.badRequest().build();
        }
        Usuario result = usuarioService.guardarUsuario(usuarioDTO);
        return ResponseEntity.ok(result);
    }



}
