package com.petadoption.service;

import com.petadoption.model.User;
import com.petadoption.repository.SavedPetsRepository;
import com.petadoption.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing User entities.
 * Provides methods to retrieve, save, update, and delete users.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SavedPetsRepository savedPetsRepository;

    /**
     * Retrieves all users from the repository.
     *
     * @return a list of all User entities.
     */
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Finds a user by its ID.
     *
     * @param id the ID of the user.
     * @return an Optional containing the User if found, or empty if not found.
     */
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Finds a user by email.
     *
     * @param email the email of the user.
     * @return an Optional containing the User if found, or empty if not found.
     */
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Saves a new user or updates an existing user.
     *
     * @param user the User entity to be saved or updated.
     * @return the saved or updated User entity.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Deletes a user by its ID.
     * Also deletes all saved pets associated with the user.
     *
     * @param id the ID of the user to delete.
     */
    public void deleteUserById(Long id) {
        savedPetsRepository.deleteAll(savedPetsRepository.findByIdUserId(id));
        userRepository.deleteById(id);
    }

    /**
     * Updates an existing user with new details.
     *
     * @param id the ID of the user to update.
     * @param user the User entity containing new details.
     * @return the updated User entity.
     * @throws IllegalArgumentException if the user with the given ID is not found.
     */
    public User editUser(Long id, User user) {
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            // Update the existing user with values from user
            existingUser.setEmail(user.getEmail());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setPhone(user.getPhone());
            existingUser.setAddress(user.getAddress());
            // You can add more fields to update as needed

            // Save the updated user
            return userRepository.save(existingUser);
        } else {
            // Handle the case where the user with the given ID doesn't exist
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }
}
