package com.fbaron.bankingbackendsb.user.business;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserUsecase {
    //    UserDAO userDAO = new UserDAO();
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//Check if user exists ; exception or create user
    @Override
    public User createUser(User user) {
        if (Objects.isNull(user.getUsername()) || Objects.isNull(user.getPassword()) || user.getUsername().isBlank() || user.getPassword().isBlank()) {
            throw new RuntimeException("Username can't be null or blank");
        }
        var userExists = userRepository.findUserByUsername(user.getUsername());
        if (userExists.isPresent()) {
            throw new RuntimeException("User is already exists.");
        }
        User createUser = userRepository.saveUser(user);
        return createUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

// Spring manages the lifecycle of the bean with simple annotation Service with
// IoC --> Inversion of Control and implementation of IoC is by dependency inversion
// Dependency injection ??
// IoC --. principle engg



