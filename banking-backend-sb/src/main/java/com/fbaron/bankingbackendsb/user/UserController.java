package com.fbaron.bankingbackendsb.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    Map<String, User> users = new HashMap<>();

    // Create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        users.put(user.username, user);
        return ResponseEntity.created(null).body(user);
    }
}



