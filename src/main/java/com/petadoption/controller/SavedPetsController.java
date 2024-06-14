package com.petadoption.controller;

import com.petadoption.DTOs.SavedPetDTO;
import com.petadoption.service.SavedPetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savedPets")
public class SavedPetsController {

    @Autowired
    private SavedPetsService savedPetsService;

    @GetMapping
    public ResponseEntity<List<SavedPetDTO>> getAllSavedPets() {
        List<SavedPetDTO> savedPetsList = savedPetsService.getAllSavedPets();
        return new ResponseEntity<>(savedPetsList, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SavedPetDTO>> getSavedPetsByUserId(@PathVariable Long userId) {
        List<SavedPetDTO> savedPetsList = savedPetsService.getSavedPetsByUserId(userId);
        return new ResponseEntity<>(savedPetsList, HttpStatus.OK);
    }

    @GetMapping("/pet/{petId}")
    public ResponseEntity<List<SavedPetDTO>> getSavedPetsByPetId(@PathVariable Long petId) {
        List<SavedPetDTO> savedPetsList = savedPetsService.getSavedPetsByPetId(petId);
        return new ResponseEntity<>(savedPetsList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SavedPetDTO> savePet(@RequestBody SavedPetDTO savedPetsDTO) {
        SavedPetDTO savedPet = savedPetsService.savePet(savedPetsDTO);
        return new ResponseEntity<>(savedPet, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{userId}/pet/{petId}")
    public ResponseEntity<Void> deleteSavedPet(@PathVariable Long userId, @PathVariable Long petId) {
        savedPetsService.deleteSavedPet(userId, petId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
