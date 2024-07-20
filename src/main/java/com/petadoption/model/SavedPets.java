package com.petadoption.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a SavedPets entity in the pet adoption system.
 * This entity keeps track of pets saved by users.
 */
@Entity
@Table(name = "savedPets")
public class SavedPets implements Serializable {

    /**
     * The composite key for the SavedPets entity.
     */
    @EmbeddedId
    private SavedPetsId id;

    /**
     * Constructs a new SavedPets entity with the specified composite key.
     *
     * @param id the composite key representing the saved pet and user.
     */
    public SavedPets(SavedPetsId id) {
        this.id = id;
    }

    /**
     * Default constructor for the SavedPets entity.
     */
    public SavedPets() {}

    /**
     * Gets the composite key of the saved pet.
     *
     * @return the composite key.
     */
    public SavedPetsId getId() {
        return id;
    }

    /**
     * Sets the composite key of the saved pet.
     *
     * @param id the composite key to set.
     */
    public void setId(SavedPetsId id) {
        this.id = id;
    }

    /**
     * Checks if this SavedPets object is equal to another object.
     *
     * @param o the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SavedPets)) return false;
        SavedPets that = (SavedPets) o;
        return Objects.equals(getId(), that.getId());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
