package com.petadoption.service;

import com.petadoption.DTOs.PetDTO;
import com.petadoption.model.Pet;
import com.petadoption.model.PetType;
import com.petadoption.model.User;
import com.petadoption.repository.PetRepository;
import com.petadoption.repository.PetTypeRepository;
import com.petadoption.repository.SavedPetsRepository;
import com.petadoption.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Pet entities.
 * Provides methods to create, read, update, and delete pets, as well as find pets by filters.
 */
@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetTypeRepository petTypeRepository;

    @Autowired
    private SavedPetsRepository savedPetsRepository;

    /**
     * Creates a new pet based on the provided PetDTO.
     *
     * @param petDTO the data transfer object containing pet details.
     * @return the created Pet entity.
     */
    public Pet createPet(PetDTO petDTO) {
        Pet pet = new Pet();
        setPetDetails(pet, petDTO);
        return petRepository.save(pet);
    }

    /**
     * Finds all pets.
     *
     * @return a list of all Pet entities.
     */
    public List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    /**
     * Finds a pet by its ID.
     *
     * @param id the ID of the pet.
     * @return an Optional containing the Pet if found, or empty if not found.
     */
    public Optional<Pet> findPetById(Long id) {
        return petRepository.findById(id);
    }

    /**
     * Deletes a pet by its ID.
     * Also deletes all saved pets associated with the pet.
     *
     * @param id the ID of the pet to delete.
     */
    public void deletePetById(Long id) {
        savedPetsRepository.deleteAll(savedPetsRepository.findByIdPetId(id));
        petRepository.deleteById(id);
    }

    /**
     * Updates an existing pet with new details from the provided PetDTO.
     *
     * @param id the ID of the pet to update.
     * @param petDTO the data transfer object containing new pet details.
     * @return the updated Pet entity.
     * @throws RuntimeException if the pet is not found.
     */
    public Pet editPet(Long id, PetDTO petDTO) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found"));
        setPetDetails(pet, petDTO);
        return petRepository.save(pet);
    }

    /**
     * Finds pets based on the provided filters.
     *
     * @param typeId the type ID of the pet (optional).
     * @param minAge the minimum age of the pet in years (optional).
     * @param maxAge the maximum age of the pet in years (optional).
     * @param name   the name of the pet (optional).
     * @return a list of pets matching the provided filters.
     */
    public List<Pet> findPetsByFilters(Long typeId, Integer minAge, Integer maxAge, String name) {
        return petRepository.findPetsByFilters(typeId, minAge, maxAge, name);
    }

    /**
     * Sets the details of a Pet entity based on the provided PetDTO.
     *
     * @param pet the Pet entity to update.
     * @param petDTO the data transfer object containing pet details.
     * @throws RuntimeException if the user or pet type is not found.
     */
    private void setPetDetails(Pet pet, PetDTO petDTO) {
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
    }
}
