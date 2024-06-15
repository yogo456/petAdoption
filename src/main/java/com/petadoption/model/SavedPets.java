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


    public SavedPets(SavedPetsId id) {
        this.id = id;
    }

    public SavedPets() {}

    public SavedPetsId getId() {
        return id;
    }

    public void setId(SavedPetsId id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SavedPets)) return false;
        SavedPets that = (SavedPets) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}