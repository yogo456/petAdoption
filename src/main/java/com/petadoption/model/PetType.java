package com.petadoption.model;

import javax.persistence.*;

@Entity
public class PetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    // Getters and setters
}
