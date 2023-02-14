package com.example.triviatecnologica.repository;

import com.example.triviatecnologica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
