package controllers;

import services.UserService;

import java.util.Scanner;
import java.sql.ResultSet;

public class UserController {
    private final UserService us = new UserService();
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
        scanner.nextLine();

        switch (choice) {
            case 1:
                uc.postNewUser(scanner);
                break;
            case 2:
                uc.getAllUsers();
                break;
            case 3:
                uc.getUserById(scanner);
                break;
            case 4:
                uc.putUserById(scanner);
                break;
            case 5:
                uc.deleteUserById(scanner);
                break;
            default:
                run();
        }
    }

    public void postNewUser(Scanner scanner) {
        try {
            System.out.println("Enter new user information");
            System.out.println("1. Name");
            System.out.println("2. Phone number");
            System.out.println("3. Email");
            System.out.println("4. Address");

            String name = scanner.nextLine();
            String phoneNumber = scanner.nextLine();
            String email = scanner.nextLine();
            String address = scanner.nextLine();

            String result = us.addNewUserService(name, phoneNumber, email, address);

            System.out.println("Use this id if you want to get the information of this user : ");
            System.out.println(result);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void getAllUsers() {
        try {
            ResultSet rs = us.getAllUsers();
            while(rs.next()) {
                System.out.printf("%-25s", rs.getString("name"));
                System.out.printf("%-25s", rs.getString("phone_number"));
                System.out.printf("%-25s", rs.getString("email"));
                System.out.printf("%-25s", rs.getString("address"));
                System.out.println();
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void getUserById(Scanner scanner) {
        try {
            System.out.println("Enter the user id");
            String id = scanner.nextLine();

            ResultSet rs = us.getUserByIdService(id);
            while(rs.next()) {
                System.out.printf("%-25s", rs.getString("name"));
                System.out.printf("%-25s", rs.getString("phone_number"));
                System.out.printf("%-25s", rs.getString("email"));
                System.out.printf("%-25s", rs.getString("address"));
                System.out.println();
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void putUserById(Scanner scanner) {
        try {
            System.out.println("Enter user information for update");
            System.out.println("1. Id user");
            System.out.println("2. Name");
            System.out.println("3. Phone number");
            System.out.println("4. Email");
            System.out.println("5. Address");

            String id = scanner.nextLine();
            String name = scanner.nextLine();
            String phoneNumber = scanner.nextLine();
            String email = scanner.nextLine();
            String address = scanner.nextLine();

            int affectedRow = us.updateUserByIdService(id, name, phoneNumber, email, address);
            if (affectedRow == 1) {
                System.out.println("Update success");
            } else {
                System.out.println("Update failed");
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void deleteUserById(Scanner scanner) {
        {
            try {
                System.out.println("Enter the user id");
                String id = scanner.nextLine();

                int affectedRow = us.deleteUserByIdService(id);
                if (affectedRow == 1) {
                    System.out.println("Delete success");
                } else {
                    System.out.println("Delete failed");
                }
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
