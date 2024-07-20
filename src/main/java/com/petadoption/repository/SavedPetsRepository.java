package com.petadoption.repository;

import com.petadoption.model.SavedPets;
import com.petadoption.model.SavedPetsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing SavedPets entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface SavedPetsRepository extends JpaRepository<SavedPets, SavedPetsId> {

    /**
     * Finds saved pets by user ID.
     *
     * @param userId the ID of the user.
     * @return a list of saved pets associated with the given user ID.
     */
    List<SavedPets> findByIdUserId(Long userId);

    /**
     * Finds saved pets by pet ID.
     *
     * @param petId the ID of the pet.
     * @return a list of saved pets associated with the given pet ID.
     */
    List<SavedPets> findByIdPetId(Long petId);
}
