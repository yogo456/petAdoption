package com.petadoption.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents the composite key for the SavedPets entity.
 * This key is a combination of userId and petId.
 */
@Embeddable
public class SavedPetsId implements Serializable {

    /**
     * The user ID part of the composite key.
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * The pet ID part of the composite key.
     */
    @Column(name = "pet_id")
    private Long petId;

    /**
     * Default constructor for the SavedPetsId composite key.
     */
    public SavedPetsId() {
    }

    /**
     * Constructs a new SavedPetsId with the specified user ID and pet ID.
     *
     * @param userId the user ID.
     * @param petId the pet ID.
     */
    public SavedPetsId(Long userId, Long petId) {
        this.userId = userId;
        this.petId = petId;
    }

    /**
     * Gets the user ID of the composite key.
     *
     * @return the user ID.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID of the composite key.
     *
     * @param userId the user ID to set.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the pet ID of the composite key.
     *
     * @return the pet ID.
     */
    public Long getPetId() {
        return petId;
    }

    /**
     * Sets the pet ID of the composite key.
     *
     * @param petId the pet ID to set.
     */
    public void setPetId(Long petId) {
        this.petId = petId;
    }

    /**
     * Checks if this SavedPetsId object is equal to another object.
     *
     * @param o the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SavedPetsId)) return false;
        SavedPetsId that = (SavedPetsId) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getPetId(), that.getPetId());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getPetId());
    }
}
