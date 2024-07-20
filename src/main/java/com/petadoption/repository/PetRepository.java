package com.petadoption.repository;

import com.petadoption.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Pet entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    /**
     * Finds pets based on the provided filters.
     *
     * @param typeId the type ID of the pet (optional).
     * @param minAge the minimum age of the pet in years (optional).
     * @param maxAge the maximum age of the pet in years (optional).
     * @param name   the name of the pet (optional).
     * @return a list of pets matching the provided filters.
     */
    @Query("SELECT p FROM Pet p WHERE " +
            "(:typeId IS NULL OR p.type.id = :typeId) AND " +
            "(:minAge IS NULL OR TIMESTAMPDIFF(YEAR, p.birthDate, CURRENT_DATE) >= :minAge) AND " +
            "(:maxAge IS NULL OR TIMESTAMPDIFF(YEAR, p.birthDate, CURRENT_DATE) <= :maxAge) AND " +
            "(:name IS NULL OR LOWER(p.name) LIKE CONCAT('%', LOWER(:name), '%'))")
    List<Pet> findPetsByFilters(@Param("typeId") Long typeId,
                                @Param("minAge") Integer minAge,
                                @Param("maxAge") Integer maxAge,
                                @Param("name") String name);
}
