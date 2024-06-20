package com.petadoption.repository;

import com.petadoption.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
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
