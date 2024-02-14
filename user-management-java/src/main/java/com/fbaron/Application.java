package com.fbaron;

import com.fbaron.user.presentation.UserConsole;

import java.util.Scanner;

/**
 * @author Ferney Estupinan Baron
 * @since 2/13/2024
 */
public class Application {

    private static final UserConsole userConsole = new UserConsole();

    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        System.out.println("Program started successfully");
        System.out.println("----------------------------------------------------");

        int option = 0;
        while (option != 100) {
            System.out.println();
            System.out.println("Please select an option:");
            System.out.println("1. Create a User");
            System.out.println("2. Read all users");
            System.out.println("3. Read a user by usernname");
            System.out.println("4. Update a user");
            System.out.println("5. Delete a user");
            System.out.println("100. Exit");
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    userConsole.create();
                    break;
                case 2:
                    userConsole.readAll();
                    break;
                case 3:
                    userConsole.readByUsername();
                    break;
                case 4:
                    userConsole.update();
                    break;
                case 5:
                    userConsole.delete();
                    break;
                case 100:
                    System.out.println("100. Exit");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

}
