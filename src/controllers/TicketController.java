package controllers;

import java.sql.ResultSet;
import java.util.Scanner;

import implementations.TicketControllerImplementation;
import services.TicketService;
public class TicketController implements TicketControllerImplementation {
    private final TicketService ts = new TicketService();
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        TicketController tc = new TicketController();

        System.out.println("===========================");
        System.out.println("Add new ticket       -> (1)");
        System.out.println("Get all tickets      -> (2)");
        System.out.println("Get ticket by id     -> (3)");
        System.out.println("Get ticket by concert name  -> (4)");
        System.out.println("Get ticket by date   -> (5)");
        System.out.println("Update ticket by id  -> (6)");
        System.out.println("Delete ticket by id  -> (7)");
        System.out.println("Show the most tickets sold on what date  -> (8)");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                tc.postNewTicket(scanner);
                break;
            case 2:
                tc.getAllTickets();
                break;
            case 3:
                tc.getTicketById(scanner);
                break;
            case 4:
                tc.getTicketByConcertName(scanner);
                break;
            case 5:
                tc.getTicketByDate(scanner);
                break;
            case 6:
                tc.putTicketById(scanner);
                break;
            case 7:
                tc.deleteTicketById(scanner);
                break;
            case 8:
                tc.getDateWithMostSoldTickets();
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

    public void getAllTickets() {
        try {
            ResultSet rs = ts.getAllTicketsService();
            while(rs.next()) {
                System.out.printf("%-25s", rs.getString("concert_name"));
                System.out.printf("%-25s", rs.getString("venue"));
                System.out.printf("%-25s", rs.getDate("concert_date"));
                System.out.printf("%-25s", rs.getString("concert_name"));
                System.out.printf("%-25s", rs.getString("organizer"));
                System.out.printf("%-25s", rs.getString("ticket_code"));
                System.out.println();
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void getTicketById(Scanner scanner) {
        try {
            System.out.println("Enter the ticket id");
            String id = scanner.nextLine();

            ResultSet rs = ts.getTicketByIdService(id);
            while(rs.next()) {
                System.out.printf("%-25s", rs.getString("concert_name"));
                System.out.printf("%-25s", rs.getString("venue"));
                System.out.printf("%-25s", rs.getDate("concert_date"));
                System.out.printf("%-25s", rs.getString("concert_name"));
                System.out.printf("%-25s", rs.getString("organizer"));
                System.out.printf("%-25s", rs.getString("ticket_code"));
                System.out.println();
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void getTicketByConcertName(Scanner scanner) {
        try {
            System.out.println("Enter the concert name");
            String concertName = scanner.nextLine();

            ResultSet rs = ts.getTicketByConcertNameService(concertName);
            while(rs.next()) {
                System.out.printf("%-25s", rs.getString("concert_name"));
                System.out.printf("%-25s", rs.getString("venue"));
                System.out.printf("%-25s", rs.getDate("concert_date"));
                System.out.printf("%-25s", rs.getString("concert_name"));
                System.out.printf("%-25s", rs.getString("organizer"));
                System.out.printf("%-25s", rs.getString("ticket_code"));
                System.out.println();
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void getTicketByDate(Scanner scanner) {
        try {
            System.out.println("Enter the ticket date");
            String date = scanner.nextLine();

            ResultSet rs = ts.getTicketByDateService(date);
            while(rs.next()) {
                System.out.printf("%-25s", rs.getString("concert_name"));
                System.out.printf("%-25s", rs.getString("venue"));
                System.out.printf("%-25s", rs.getDate("concert_date"));
                System.out.printf("%-25s", rs.getString("concert_name"));
                System.out.printf("%-25s", rs.getString("organizer"));
                System.out.printf("%-25s", rs.getString("ticket_code"));
                System.out.println();;
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void putTicketById(Scanner scanner) {
        try {
            System.out.println("Enter ticket information for update");
            System.out.println("1. id ticket");
            System.out.println("2. Concert name");
            System.out.println("3. Venue");
            System.out.println("4. Date");
            System.out.println("5. Organizer");
            System.out.println("6. Price");
            System.out.println("7. Discount");

            String id = scanner.nextLine();
            String concertName = scanner.nextLine();
            String venue = scanner.nextLine();
            String date = scanner.nextLine();
            String organizer = scanner.nextLine();
            double price = scanner.nextDouble();
            double discount = scanner.nextDouble();

            int affectedRow = ts.updateTicketService(id, concertName, venue, date, organizer, price, discount);

            if (affectedRow == 1) {
                System.out.println("Update success");
            } else {
                System.out.println("Update failed");
            }

        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void deleteTicketById(Scanner scanner) {
        try {
            System.out.println("Enter the ticket id");
            String id = scanner.nextLine();

            int affectedRow = ts.deleteTicketByIdService(id);
            if (affectedRow == 1) {
                System.out.println("Delete success");
            } else {
                System.out.println("Delete failed");
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void getDateWithMostSoldTickets() {
        try {
            ResultSet rs = ts.getDateWithMostSoldTickets();

            System.out.println("Here it is most sold date");
            while(rs.next()) {
                System.out.printf("%-25s", rs.getString("transaction_date"));
                System.out.printf("%-25s", rs.getString("total_sales"));
                System.out.println();
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}
