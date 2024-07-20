package com.petadoption.service;

import com.petadoption.DTOs.SavedPetDTO;
import com.petadoption.model.SavedPets;
import com.petadoption.model.SavedPetsId;
import com.petadoption.repository.SavedPetsRepository;
import com.petadoption.utils.SavedPetsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing SavedPets entities.
 * Provides methods to retrieve, save, and delete saved pets.
 */
@Service
public class SavedPetsService {

    @Autowired
    private SavedPetsRepository savedPetsRepository;

    /**
     * Retrieves all saved pets and converts them to DTOs.
     *
     * @return a list of SavedPetDTOs representing all saved pets.
     */
    public List<SavedPetDTO> getAllSavedPets() {
        return savedPetsRepository.findAll().stream()
                .map(SavedPetsConverter::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all saved pets for a specific user and converts them to DTOs.
     *
     * @param userId the ID of the user whose saved pets are to be retrieved.
     * @return a list of SavedPetDTOs representing saved pets for the specified user.
     */
    public List<SavedPetDTO> getSavedPetsByUserId(Long userId) {
        return savedPetsRepository.findByIdUserId(userId).stream()
                .map(SavedPetsConverter::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all saved pets for a specific pet and converts them to DTOs.
     *
     * @param petId the ID of the pet whose saved records are to be retrieved.
     * @return a list of SavedPetDTOs representing saved records for the specified pet.
     */
    public List<SavedPetDTO> getSavedPetsByPetId(Long petId) {
        return savedPetsRepository.findByIdPetId(petId).stream()
                .map(SavedPetsConverter::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Saves a new saved pet record.
     *
     * @param savedPetsDTO the DTO containing the details of the saved pet.
     * @return the SavedPetDTO representing the saved pet record.
     */
    public SavedPetDTO savePet(SavedPetDTO savedPetsDTO) {
        SavedPets savedPets = SavedPetsConverter.toEntity(savedPetsDTO);
        SavedPets savedEntity = savedPetsRepository.save(savedPets);
        return SavedPetsConverter.toDTO(savedEntity);
    }

    /**
     * Deletes a saved pet record based on user ID and pet ID.
     *
     * @param userId the ID of the user.
     * @param petId  the ID of the pet.
     */
    public void deleteSavedPet(Long userId, Long petId) {
        SavedPetsId savedPetsId = new SavedPetsId(userId, petId);
        savedPetsRepository.deleteById(savedPetsId);
    }
}
