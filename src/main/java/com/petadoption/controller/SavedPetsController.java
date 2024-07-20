package com.petadoption.controller;

import com.petadoption.DTOs.SavedPetDTO;
import com.petadoption.service.SavedPetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing saved pets.
 */
@RestController
@RequestMapping("/api/savedPets")
public class SavedPetsController {

    @Autowired
    private SavedPetsService savedPetsService;

    /**
     * Retrieves a list of all saved pets.
     *
     * @return a {@link ResponseEntity} containing a list of {@link SavedPetDTO} and an HTTP status of OK.
     */
    @GetMapping
    public ResponseEntity<List<SavedPetDTO>> getAllSavedPets() {
        List<SavedPetDTO> savedPetsList = savedPetsService.getAllSavedPets();
        return new ResponseEntity<>(savedPetsList, HttpStatus.OK);
    }

    /**
     * Retrieves a list of saved pets by user ID.
     *
     * @param userId the ID of the user whose saved pets are to be retrieved.
     * @return a {@link ResponseEntity} containing a list of {@link SavedPetDTO} and an HTTP status of OK.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SavedPetDTO>> getSavedPetsByUserId(@PathVariable Long userId) {
        List<SavedPetDTO> savedPetsList = savedPetsService.getSavedPetsByUserId(userId);
        return new ResponseEntity<>(savedPetsList, HttpStatus.OK);
    }

    /**
     * Retrieves a list of saved pets by pet ID.
     *
     * @param petId the ID of the pet whose saved records are to be retrieved.
     * @return a {@link ResponseEntity} containing a list of {@link SavedPetDTO} and an HTTP status of OK.
     */
    @GetMapping("/pet/{petId}")
    public ResponseEntity<List<SavedPetDTO>> getSavedPetsByPetId(@PathVariable Long petId) {
        List<SavedPetDTO> savedPetsList = savedPetsService.getSavedPetsByPetId(petId);
        return new ResponseEntity<>(savedPetsList, HttpStatus.OK);
    }

    /**
     * Saves a pet to the user's saved pets list.
     *
     * @param savedPetsDTO the {@link SavedPetDTO} containing the details of the pet to be saved.
     * @return a {@link ResponseEntity} containing the saved {@link SavedPetDTO} and an HTTP status of CREATED.
     */
    @PostMapping
    public ResponseEntity<SavedPetDTO> savePet(@RequestBody SavedPetDTO savedPetsDTO) {
        SavedPetDTO savedPet = savedPetsService.savePet(savedPetsDTO);
        return new ResponseEntity<>(savedPet, HttpStatus.CREATED);
    }

    /**
     * Deletes a saved pet record by user ID and pet ID.
     *
     * @param userId the ID of the user whose saved pet record is to be deleted.
     * @param petId the ID of the pet to be removed from the saved list.
     * @return a {@link ResponseEntity} with an HTTP status of NO_CONTENT.
     */
    @DeleteMapping("/user/{userId}/pet/{petId}")
    public ResponseEntity<Void> deleteSavedPet(@PathVariable Long userId, @PathVariable Long petId) {
        savedPetsService.deleteSavedPet(userId, petId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
