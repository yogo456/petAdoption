package com.petadoption.model;

import javax.persistence.*;

/**
 * Represents a PetType entity in the pet adoption system.
 * Each pet type has an id and a type name.
 */
@Entity
public class PetType {

    /**
     * The unique identifier for each PetType.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the pet type (e.g., Dog, Cat).
     */
    private String type;

    // Getters and setters

    /**
     * Gets the unique identifier of the pet type.
     *
     * @return the id of the pet type.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the pet type.
     *
     * @param id the id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the pet type.
     *
     * @return the type of the pet.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the name of the pet type.
     *
     * @param type the type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns a string representation of the pet type.
     *
     * @return a string representing the pet type.
     */
    @Override
    public String toString() {
        return "PetType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
