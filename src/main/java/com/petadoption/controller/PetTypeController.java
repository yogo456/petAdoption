package com.petadoption.controller;

import com.petadoption.model.PetType;
import com.petadoption.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing {@link PetType} entities.
 */
@RestController
@RequestMapping("/api/pet-types")
public class PetTypeController {

    @Autowired
    private PetTypeService petTypeService;

    /**
     * Retrieves a list of all pet types.
     *
     * @return a list of {@link PetType} entities.
     */
    @GetMapping
    public List<PetType> getAllPetTypes() {
        return petTypeService.findAllPetTypes();
    }
}
