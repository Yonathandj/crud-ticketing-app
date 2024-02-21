package implementations;

import java.util.Scanner;

public interface UserControllerImplementation {
    public void postNewUser(Scanner scanner);
    public void getAllUsers();
    public void getUserById(Scanner scanner);
    public void putUserById(Scanner scanner);
    public void deleteUserById(Scanner scanner);
}
