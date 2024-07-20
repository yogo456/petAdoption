package com.petadoption.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Represents a Pet entity in the pet adoption system.
 * Each pet has an owner, name, image, description, birth date, and type.
 */
@Entity
public class Pet {

    /**
     * The unique identifier for each Pet.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The owner of the pet, represented by a User entity.
     */
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    /**
     * The name of the pet.
     */
    private String name;

    /**
     * The image of the pet stored as a large object (LOB).
     */
    @Lob
    @Column(columnDefinition = "TEXT")
    private String image;

    /**
     * The description of the pet.
     */
    private String description;

    /**
     * The birth date of the pet.
     */
    private LocalDate birthDate;

    /**
     * The type of the pet, represented by a PetType entity.
     */
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private PetType type;

    // Getters and setters

    /**
     * Gets the unique identifier of the pet.
     *
     * @return the id of the pet.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the pet.
     *
     * @param id the id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the owner of the pet.
     *
     * @return the owner of the pet.
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the pet.
     *
     * @param owner the owner to set.
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Gets the name of the pet.
     *
     * @return the name of the pet.
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
     * Gets the image of the pet.
     *
     * @return the image of the pet.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image of the pet.
     *
     * @param image the image to set.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the description of the pet.
     *
     * @return the description of the pet.
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
     * @return the birthdate of the pet.
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
     * Gets the type of the pet.
     *
     * @return the type of the pet.
     */
    public PetType getType() {
        return type;
    }

    /**
     * Sets the type of the pet.
     *
     * @param type the type to set.
     */
    public void setType(PetType type) {
        this.type = type;
    }

    /**
     * Returns a string representation of the pet.
     *
     * @return a string representing the pet.
     */
    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", owner=" + owner.getId() +  // Avoid printing full owner details to prevent circular reference
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", birthDate=" + birthDate +
                ", type=" + type +
                '}';
    }
}
