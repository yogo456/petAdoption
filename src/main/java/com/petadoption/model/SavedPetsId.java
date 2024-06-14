package com.petadoption.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SavedPetsId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pet_id")
    private Long petId;

    public SavedPetsId() {
    }

    public SavedPetsId(Long userId, Long petId) {
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
        if (!(o instanceof SavedPetsId)) return false;
        SavedPetsId that = (SavedPetsId) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getPetId(), that.getPetId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getPetId());
    }
}
