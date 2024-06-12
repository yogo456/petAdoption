package com.petadoption.service;

import com.petadoption.DTOs.PetDTO;
import com.petadoption.model.Pet;
import com.petadoption.model.PetType;
import com.petadoption.model.User;
import com.petadoption.repository.PetRepository;
import com.petadoption.repository.PetTypeRepository;
import com.petadoption.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetTypeRepository petTypeRepository;

    public Pet createPet(PetDTO petDTO) {
        Pet pet = new Pet();

        // Set pet details
        pet.setName(petDTO.getName());
        pet.setImage(petDTO.getImage());
        pet.setDescription(petDTO.getDescription());
        pet.setBirthDate(petDTO.getBirthDate());

        // Fetch and set the owner
        User owner = userRepository.findById(petDTO.getOwnerId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        pet.setOwner(owner);

        // Fetch and set the pet type
        PetType type = petTypeRepository.findById(petDTO.getTypeId())
                .orElseThrow(() -> new RuntimeException("Pet type not found"));
        pet.setType(type);

        // Save and return the pet
        return petRepository.save(pet);
    }

    public List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> findPetById(Long id) {
        return petRepository.findById(id);
    }

    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }
}
