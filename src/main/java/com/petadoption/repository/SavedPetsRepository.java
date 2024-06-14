package com.petadoption.repository;
import com.petadoption.model.SavedPets;
import com.petadoption.model.SavedPetsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedPetsRepository extends JpaRepository<SavedPets, SavedPetsId> {
    List<SavedPets> findByIdUserId(Long userId);
    List<SavedPets> findByIdPetId(Long petId);
}
