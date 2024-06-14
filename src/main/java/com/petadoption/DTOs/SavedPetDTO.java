package com.petadoption.DTOs;

import java.time.LocalDateTime;
import java.util.Objects;

public class SavedPetDTO {

    private Long userId;
    private Long petId;
    private LocalDateTime savedAt;

    public SavedPetDTO() {
    }

    public SavedPetDTO(Long userId, Long petId, LocalDateTime savedAt) {
        this.userId = userId;
        this.petId = petId;
        this.savedAt = savedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public LocalDateTime getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(LocalDateTime savedAt) {
        this.savedAt = savedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SavedPetDTO)) return false;
        SavedPetDTO that = (SavedPetDTO) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getPetId(), that.getPetId()) &&
                Objects.equals(getSavedAt(), that.getSavedAt());
    }

    @Override
    public String toString() {
        return "SavedPetsDTO{" +
                "userId=" + userId +
                ", petId=" + petId +
                ", savedAt=" + savedAt +
                '}';
    }
}
