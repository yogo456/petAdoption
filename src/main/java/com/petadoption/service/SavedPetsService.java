package com.petadoption.service;

import com.petadoption.DTOs.SavedPetDTO;
import com.petadoption.model.SavedPets;
import com.petadoption.model.SavedPetsId;
import com.petadoption.repository.SavedPetsRepository;
import com.petadoption.utils.SavedPetsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SavedPetsService {

    @Autowired
    private SavedPetsRepository savedPetsRepository;

    public List<SavedPetDTO> getAllSavedPets() {
        return savedPetsRepository.findAll().stream()
                .map(SavedPetsConverter::toDTO)
                .collect(Collectors.toList());
    }

    public List<SavedPetDTO> getSavedPetsByUserId(Long userId) {
        return savedPetsRepository.findByIdUserId(userId).stream()
                .map(SavedPetsConverter::toDTO)
                .collect(Collectors.toList());
    }

    public List<SavedPetDTO> getSavedPetsByPetId(Long petId) {
        return savedPetsRepository.findByIdPetId(petId).stream()
                .map(SavedPetsConverter::toDTO)
                .collect(Collectors.toList());
    }

    public SavedPetDTO savePet(SavedPetDTO savedPetsDTO) {
        SavedPets savedPets = SavedPetsConverter.toEntity(savedPetsDTO);
        SavedPets savedEntity = savedPetsRepository.save(savedPets);
        return SavedPetsConverter.toDTO(savedEntity);
    }

    public void deleteSavedPet(Long userId, Long petId) {
        SavedPetsId savedPetsId = new SavedPetsId(userId, petId);
        savedPetsRepository.deleteById(savedPetsId);
    }
}

