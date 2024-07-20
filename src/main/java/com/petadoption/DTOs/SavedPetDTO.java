package com.petadoption.DTOs;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) for transferring saved pet data.
 * Used to encapsulate the data related to a saved pet interaction between user and pet when interacting with the API.
 */
public class SavedPetDTO {

    private Long userId;
    private Long petId;

    /**
     * Default constructor.
     */
    public SavedPetDTO() {
    }

    /**
     * Constructs a new SavedPetDTO with the specified user ID and pet ID.
     *
     * @param userId the ID of the user who saved the pet.
     * @param petId the ID of the saved pet.
     */
    public SavedPetDTO(Long userId, Long petId) {
        this.userId = userId;
        this.petId = petId;
    }

    /**
     * Gets the ID of the user who saved the pet.
     *
     * @return the user ID.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user who saved the pet.
     *
     * @param userId the user ID to set.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the ID of the saved pet.
     *
     * @return the pet ID.
     */
    public Long getPetId() {
        return petId;
    }

    /**
     * Sets the ID of the saved pet.
     *
     * @param petId the pet ID to set.
     */
    public void setPetId(Long petId) {
        this.petId = petId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SavedPetDTO)) return false;
        SavedPetDTO that = (SavedPetDTO) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getPetId(), that.getPetId());
    }

    @Override
    public String toString() {
        return "SavedPetDTO{" +
                "userId=" + userId +
                ", petId=" + petId +
                '}';
    }
}
