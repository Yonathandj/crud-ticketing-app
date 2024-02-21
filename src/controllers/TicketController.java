package controllers;

import java.util.Scanner;

import services.TicketService;
public class TicketController {
    private final TicketService ts = new TicketService();
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        TicketController tc = new TicketController();

        System.out.println("===========================");
        System.out.println("Add new ticket       -> (1)");
        System.out.println("Get all tickets      -> (2)");
        System.out.println("Get ticket by id     -> (3)");
        System.out.println("Update ticket by id  -> (4)");
        System.out.println("Delete ticket by id  -> (5)");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                tc.postNewTicket(scanner);
                break;
            case 2:
                tc.getAllTickets(scanner);
                break;
            case 3:
                tc.getTicketById(scanner);
                break;
            case 4:
                tc.putTicketById(scanner);
                break;
            case 5:
                tc.deleteTicketById(scanner);
                break;
            default:
                run();
        }
    }

    public void postNewTicket(Scanner scanner) {
        try {
            System.out.println("Enter new ticket information");
            System.out.println("1. Concert name");
            System.out.println("2. Venue");
            System.out.println("3. Date");
            System.out.println("4. Organizer");
            System.out.println("5. Price");
            System.out.println("6. Discount");

            String concertName = scanner.nextLine();
            String venue = scanner.nextLine();
            String date = scanner.nextLine();
            String organizer = scanner.nextLine();
            double price = scanner.nextDouble();
            double discount = scanner.nextDouble();

            String result = ts.addNewTicketService(concertName, venue, date, organizer, price, discount);

            System.out.println("Use this id if you want to get the information of this ticket : ");
            System.out.println(result);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void getAllTickets(Scanner scanner) {

    }

    public void getTicketById(Scanner scanner) {

    }

    public void putTicketById(Scanner scanner) {

    }

    public void deleteTicketById(Scanner scanner) {

    }
}
