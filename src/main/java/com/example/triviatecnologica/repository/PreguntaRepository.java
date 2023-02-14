package com.example.triviatecnologica.repository;

import com.example.triviatecnologica.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}
