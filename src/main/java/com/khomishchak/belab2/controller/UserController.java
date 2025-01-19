package com.khomishchak.belab2.controller;

import com.khomishchak.belab2.model.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private final Map<Long, User> users = new HashMap<>();
    private Long idCounter = 1L;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        user.setId(idCounter++);
        users.put(user.getId(), user);
        return user;
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Long userId) {
        return users.getOrDefault(userId, null);
    }

    @GetMapping("/users")
    public Collection<User> getAllUsers() {
        return users.values();
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        users.remove(userId);
    }
}
