package controllers;

import java.util.Scanner;

public class TicketController {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        TicketController tc = new TicketController();

        System.out.println("Add new ticket (1)");
        System.out.println("Get all tickets (2)");
        System.out.println("Get ticket by id (3)");
        System.out.println("Update ticket by id (4)");
        System.out.println("Delete ticket by id (5)");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                tc.postNewTicket();
                break;
            case 2:
                tc.getAllTickets();
                break;
            case 3:
                tc.getTicketById();
                break;
            case 4:
                tc.putTicketById();
                break;
            case 5:
                tc.deleteTicketById();
                break;
            default:
                run();
        }
    }

    public void postNewTicket() {

    }

    public void getAllTickets() {

    }

    public void getTicketById() {

    }

    public void putTicketById() {

    }

    public void deleteTicketById() {

    }
}
