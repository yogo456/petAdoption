package com.petadoption.DTOs;

import java.time.LocalDateTime;
import java.util.Objects;

public class SavedPetDTO {

    private Long userId;
    private Long petId;

    public SavedPetDTO() {
    }

    public SavedPetDTO(Long userId, Long petId) {
        this.userId = userId;
        this.petId = petId;
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
        return "SavedPetsDTO{" +
                "userId=" + userId +
                ", petId=" + petId +
                '}';
    }
}
