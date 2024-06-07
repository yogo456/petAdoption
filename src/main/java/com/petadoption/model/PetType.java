package com.petadoption.model;

import javax.persistence.*;

@Entity
public class PetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PetType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
