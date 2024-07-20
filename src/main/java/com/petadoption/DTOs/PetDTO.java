package com.petadoption.DTOs;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for transferring pet data.
 * Used to encapsulate the data related to a pet when interacting with the API.
 */
public class PetDTO {

    private Long ownerId;
    private String name;
    private String image;
    private String description;
    private LocalDate birthDate;
    private Long typeId;

    /**
     * Gets the ID of the owner of the pet.
     *
     * @return the owner ID.
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the ID of the owner of the pet.
     *
     * @param ownerId the owner ID to set.
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Gets the name of the pet.
     *
     * @return the pet's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the pet.
     *
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the image URL of the pet.
     *
     * @return the pet's image URL.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image URL of the pet.
     *
     * @param image the image URL to set.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the description of the pet.
     *
     * @return the pet's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the pet.
     *
     * @param description the description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the birthdate of the pet.
     *
     * @return the pet's birthdate.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birthdate of the pet.
     *
     * @param birthDate the birthdate to set.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the ID of the pet type.
     *
     * @return the pet type ID.
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * Sets the ID of the pet type.
     *
     * @param typeId the pet type ID to set.
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "PetDTO{" +
                "ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", birthDate=" + birthDate +
                ", typeId=" + typeId +
                '}';
    }
}
