package controllers;

import java.util.Scanner;

public class UserController {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        UserController uc = new UserController();

        System.out.println("==========================");
        System.out.println("Add new user        -> (1)");
        System.out.println("Get all users       -> (2)");
        System.out.println("Get user by id      -> (3)");
        System.out.println("Update user by id   -> (4)");
        System.out.println("Delete user by id   -> (5)");

        int choice = scanner.nextInt();
        scanner.close();

        switch (choice) {
            case 1:
                uc.postNewUser();
                break;
            case 2:
                uc.getAllUsers();
                break;
            case 3:
                uc.getUserById();
                break;
            case 4:
                uc.putUserById();
                break;
            case 5:
                uc.deleteUserById();
                break;
            default:
                run();
        }
    }

    public void postNewUser() {

    }

    public void getAllUsers() {

    }

    public void getUserById() {

    }

    public void putUserById() {

    }

    public void deleteUserById() {

    }
}
