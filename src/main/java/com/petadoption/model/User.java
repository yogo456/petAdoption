package com.petadoption.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String family;
    private String email;
    private String password;
    private String phone;
    private String address;

    // Getters and setters
}
