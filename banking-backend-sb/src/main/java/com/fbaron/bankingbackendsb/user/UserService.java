package com.fbaron.bankingbackendsb.user;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserService {
    Map<String, User> users = new HashMap<>();
       public User createUser(User user) {
           if (Objects.isNull(user.username) || Objects.isNull(user.password) || user.username.isBlank() || user.password.isBlank())
           {
//               return ResponseEntity.badRequest().build();
               return null;
           }
           users.put(user.username, user);
           return user;

       }
}
