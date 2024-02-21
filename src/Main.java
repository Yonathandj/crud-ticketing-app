import controllers.UserController;
import controllers.TicketController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("===========");
            System.out.println("Ticket -> (1)");
            System.out.println("User   -> (2)");

            int choice = scanner.nextInt();
            if(choice == 1) {
                TicketController.run();
            } else if(choice == 2) {
                UserController.run();
            }

        } catch (Exception err) {
            System.out.println("Please enter a valid input");
        }
    }
}