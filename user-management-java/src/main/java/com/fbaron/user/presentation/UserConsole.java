package com.fbaron.user.presentation;

import com.fbaron.user.business.UserService;
import com.fbaron.user.business.User;

import java.util.Optional;
import java.util.Scanner;

/**
 * @author Ferney Estupinan Baron
 * @since 2/13/2024
 */
public class UserConsole {

    private final UserService userService = new UserService();

    public void create(){
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("Create a User");

        System.out.println("Enter your username");
        String username = scanner.nextLine();
        user.setUsername(username);
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        user.setPassword(password);

        user = userService.create(user);
        System.out.println("User create: " + user.toString());
    }

    public void readAll(){
        System.out.println("Read all users");
        userService.readAll().forEach(System.out::println);
    }

    public void readByUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        if (username == null || username.isEmpty())
            throw new IllegalArgumentException("Username cannot be null or empty");
        User user = userService.readByUsername(username).orElse(null);
        System.out.println("User: " + user);
    }

    public void update(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        if (username == null || username.isEmpty())
            throw new IllegalArgumentException("Username cannot be null or empty");
        User user = userService.readByUsername(username).orElse(null);
        System.out.println("Enter your new password");
        String password = scanner.nextLine();
        user.setPassword(password);
        user = userService.update(user.getId(), user);
        System.out.println("User updated: " + user);
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        if (username == null || username.isEmpty())
            throw new IllegalArgumentException("Username cannot be null or empty");
        User user = userService.readByUsername(username).orElse(null);
        userService.delete(user.getId());
        System.out.println("User deleted: " + user);
    }

}
