package com.petadoption.utils;

import com.petadoption.DTOs.SavedPetDTO;
import com.petadoption.model.SavedPets;
import com.petadoption.model.SavedPetsId;

/**
 * Utility class for converting between {@link SavedPets} entities and {@link SavedPetDTO} data transfer objects.
 */
public class SavedPetsConverter {

    /**
     * Converts a {@link SavedPets} entity to a {@link SavedPetDTO}.
     *
     * @param savedPets the {@link SavedPets} entity to convert.
     * @return the corresponding {@link SavedPetDTO}.
     */
    public static SavedPetDTO toDTO(SavedPets savedPets) {
        return new SavedPetDTO(
                savedPets.getId().getUserId(),
                savedPets.getId().getPetId()
        );
    }

    /**
     * Converts a {@link SavedPetDTO} to a {@link SavedPets} entity.
     *
     * @param savedPetsDTO the {@link SavedPetDTO} to convert.
     * @return the corresponding {@link SavedPets} entity.
     */
    public static SavedPets toEntity(SavedPetDTO savedPetsDTO) {
        SavedPetsId savedPetsId = new SavedPetsId(
                savedPetsDTO.getUserId(),
                savedPetsDTO.getPetId()
        );
        return new SavedPets(savedPetsId);
    }
}
