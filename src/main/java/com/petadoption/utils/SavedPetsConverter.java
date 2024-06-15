package com.petadoption.utils;

import com.petadoption.DTOs.SavedPetDTO;
import com.petadoption.model.SavedPets;
import com.petadoption.model.SavedPetsId;

public class SavedPetsConverter {

    public static SavedPetDTO toDTO(SavedPets savedPets) {
        return new SavedPetDTO(
                savedPets.getId().getUserId(),
                savedPets.getId().getPetId()
        );
    }

    public static SavedPets toEntity(SavedPetDTO savedPetsDTO) {
        SavedPetsId savedPetsId = new SavedPetsId(
                savedPetsDTO.getUserId(),
                savedPetsDTO.getPetId()
        );
        return  new SavedPets(savedPetsId);
    }
}

