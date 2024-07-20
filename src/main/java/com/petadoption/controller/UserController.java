package com.petadoption.controller;

import com.petadoption.DTOs.UserDTO;
import com.petadoption.model.User;
import com.petadoption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing users.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retrieves a list of all users.
     *
     * @return a {@link ResponseEntity} containing a list of {@link User} and an HTTP status of OK.
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    /**
     * Retrieves a user by ID.
     *
     * @param id the ID of the user to be retrieved.
     * @return a {@link ResponseEntity} containing the {@link User} if found, otherwise an HTTP status of NOT_FOUND.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Logs in a user by email and password.
     *
     * @param email the email of the user.
     * @param password the password of the user.
     * @return a {@link ResponseEntity} containing the {@link User} if credentials are valid, otherwise an HTTP status of NOT_FOUND.
     */
    @GetMapping("login/{email}")
    public ResponseEntity<User> login(@PathVariable String email, @RequestParam String password) {
        Optional<User> user = userService.findUserByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Creates a new user.
     *
     * @param userDTO the {@link UserDTO} containing user details.
     * @return a {@link ResponseEntity} containing the created {@link User} and an HTTP status of OK, or BAD_REQUEST if the user already exists.
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User userModel = convertToEntity(userDTO);

        Optional<User> existingUser = userService.findUserByEmail(userModel.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.saveUser(userModel));
    }

    /**
     * Deletes a user by ID.
     *
     * @param id the ID of the user to be deleted.
     * @return a {@link ResponseEntity} with an HTTP status of NO_CONTENT.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Updates a user's details by ID.
     *
     * @param id the ID of the user to be updated.
     * @param updatedUserDTO the {@link UserDTO} containing updated user details.
     * @return a {@link ResponseEntity} containing the updated {@link User} and an HTTP status of OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO updatedUserDTO) {
        User updatedUser = userService.editUser(id, convertToEntity(updatedUserDTO));
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Converts {@link UserDTO} to {@link User}.
     *
     * @param userDTO the {@link UserDTO} to be converted.
     * @return the converted {@link User}.
     */
    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        return user;
    }
}
