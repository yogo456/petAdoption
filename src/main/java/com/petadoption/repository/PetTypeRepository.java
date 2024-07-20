package com.petadoption.repository;

import com.petadoption.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing PetType entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}
