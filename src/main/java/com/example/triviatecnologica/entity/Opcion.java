package com.example.triviatecnologica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Opcion")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
