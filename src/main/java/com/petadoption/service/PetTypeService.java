package com.petadoption.service;

import com.petadoption.model.PetType;
import com.petadoption.repository.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing PetType entities.
 * Provides methods to retrieve all pet types.
 */
@Service
public class PetTypeService {

    @Autowired
    private PetTypeRepository petTypeRepository;

    /**
     * Retrieves all pet types from the repository.
     *
     * @return a list of all PetType entities.
     */
    public List<PetType> findAllPetTypes() {
        return petTypeRepository.findAll();
    }
}
