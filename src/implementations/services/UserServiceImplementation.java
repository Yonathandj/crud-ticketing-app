package implementations.services;

import java.util.Scanner;

public interface UserServiceImplementation {
    public void postNewUser(Scanner scanner);
    public void getAllUsers();
    public void getUserById(Scanner scanner);
    public void putUserById(Scanner scanner);
    public void deleteUserById(Scanner scanner);
}
