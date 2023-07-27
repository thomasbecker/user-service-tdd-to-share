package com.daimler.userservice.resource;

import com.daimler.userservice.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 15.02.22.
 */
@RestController
@RequestMapping("/users")
public class UserResource {
    private final Set<User> users = Set.of(
            new User(UUID.randomUUID(), "First", "Last", "first@last.de"),
            new User(UUID.randomUUID(), "SecondUser", "SecondLast", "second@last.de"));

    @GetMapping
    public Set<User> getUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        return users.stream()
                .filter(user -> user.id().equals(id)).findFirst()
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User persistedUser = new User(UUID.randomUUID(), user.firstName(), user.lastName(), user.email());
        users.add(persistedUser);
        return new ResponseEntity<>(persistedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        Optional<User> userToDeleteOptional = users.stream().filter(user -> user.id().equals(id)).findFirst();
        if (userToDeleteOptional.isPresent()) {
            User userToDelete = userToDeleteOptional.get();
            users.remove(userToDelete);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
