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
//    Map<String, User> users = new HashMap<>();

    UserService userService = new UserService();

    // Create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
//        if (Objects.isNull(user.username) || Objects.isNull(user.password) || user.username.isBlank() || user.password.isBlank())
//            return ResponseEntity.badRequest().build();
//        users.put(user.username, user);
        User createUser = userService.createUser(user);
//        return ResponseEntity.created(null).body(user);
        return ResponseEntity.created(null).body(createUser);
    }
}



