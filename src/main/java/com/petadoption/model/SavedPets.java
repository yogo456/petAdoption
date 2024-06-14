package com.petadoption.model;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "savedPets")
public class SavedPets implements Serializable {

    @EmbeddedId
    private SavedPetsId id;

    @Column(name = "saved_at", nullable = false)
    private LocalDateTime savedAt;

    public SavedPets() {
        this.savedAt = LocalDateTime.now();
    }

    public SavedPets(SavedPetsId id) {
        this.id = id;
        this.savedAt = LocalDateTime.now();
    }

    public SavedPetsId getId() {
        return id;
    }

    public void setId(SavedPetsId id) {
        this.id = id;
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
        if (!(o instanceof SavedPets)) return false;
        SavedPets that = (SavedPets) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getSavedAt(), that.getSavedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSavedAt());
    }
}