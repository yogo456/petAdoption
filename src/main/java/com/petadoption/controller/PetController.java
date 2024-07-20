package com.petadoption.controller;

import com.petadoption.DTOs.PetDTO;
import com.petadoption.model.Pet;
import com.petadoption.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link Pet} entities.
 */
@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    /**
     * Retrieves a list of all pets.
     *
     * @return a list of {@link Pet} entities.
     */
    @GetMapping
    public List<Pet> getAllPets() {
        return petService.findAllPets();
    }

    /**
     * Retrieves a specific pet by its ID.
     *
     * @param id the ID of the pet to retrieve.
     * @return a {@link ResponseEntity} containing the {@link Pet} if found, otherwise a 404 Not Found response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.findPetById(id);
        return pet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Retrieves pets based on various filters.
     *
     * @param typeId optional filter for pet type ID.
     * @param minAge optional filter for minimum age.
     * @param maxAge optional filter for maximum age.
     * @param name optional filter for pet name.
     * @return a {@link ResponseEntity} containing a list of {@link Pet} entities that match the filters.
     */
    @GetMapping("/filter")
    public ResponseEntity<List<Pet>> getPetsByFilters(
            @RequestParam(required = false) Long typeId,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) String name) {
        List<Pet> pets = petService.findPetsByFilters(typeId, minAge, maxAge, name);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    /**
     * Creates a new pet.
     *
     * @param petDTO the {@link PetDTO} containing the details of the pet to create.
     * @return a {@link ResponseEntity} containing the created {@link Pet}.
     */
    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody PetDTO petDTO) {
        Pet createdPet = petService.createPet(petDTO);
        return ResponseEntity.ok(createdPet);
    }

    /**
     * Deletes a specific pet by its ID.
     *
     * @param id the ID of the pet to delete.
     * @return a {@link ResponseEntity} with no content if the deletion was successful.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Updates an existing pet.
     *
     * @param id the ID of the pet to update.
     * @param petDTO the {@link PetDTO} containing the updated details of the pet.
     * @return a {@link ResponseEntity} containing the updated {@link Pet}.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Pet> editPet(@PathVariable Long id, @RequestBody PetDTO petDTO) {
        Pet updatedPet = petService.editPet(id, petDTO);
        return new ResponseEntity<>(updatedPet, HttpStatus.OK);
    }
}
