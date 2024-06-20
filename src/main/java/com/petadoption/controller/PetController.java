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

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.findAllPets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.findPetById(id);
        return pet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Pet>> getPetsByFilters(
            @RequestParam(required = false) Long typeId,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) String name) {
        List<Pet> pets = petService.findPetsByFilters(typeId, minAge, maxAge, name);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody PetDTO pet) {
        Pet createdPet = petService.createPet(pet);
        return ResponseEntity.ok(createdPet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> editPet(@PathVariable Long id, @RequestBody PetDTO petDTO) {
        Pet updatedPet = petService.editPet(id, petDTO);
        return new ResponseEntity<>(updatedPet, HttpStatus.OK);
    }
}
