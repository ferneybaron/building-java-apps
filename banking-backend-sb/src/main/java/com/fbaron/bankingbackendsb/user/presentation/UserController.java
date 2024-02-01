package com.fbaron.bankingbackendsb.user.presentation;

import com.fbaron.bankingbackendsb.user.business.User;
import com.fbaron.bankingbackendsb.user.business.UserUsecase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    //    UserService userService = new UserService();
    private final UserUsecase userUsecase;

    public UserController(UserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }

    // Create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User createUser = userUsecase.createUser(user);
        return ResponseEntity.created(null).body(createUser);
    }
}

// High level modules should not depend on low level modules but should depend on abstraction
// Abstraction --> interface makes it loosely coupled


