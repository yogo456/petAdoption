package com.petadoption.service;

import com.petadoption.model.PetType;
import com.petadoption.repository.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetTypeService {

    @Autowired
    private PetTypeRepository petTypeRepository;

    public List<PetType> findAllPetTypes() {
        return petTypeRepository.findAll();
    }
}
