package com.fbaron.bankingbackendsb.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// To maintain the SOLID principle we have only one responsibility
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    UserService userService = new UserService();

    // Create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User createUser = userService.createUser(user);
        return ResponseEntity.created(null).body(createUser);
    }
}



