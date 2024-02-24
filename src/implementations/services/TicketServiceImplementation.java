package implementations.services;

import java.util.Scanner;

public interface TicketServiceImplementation {
    public void postNewTicket(Scanner scanner);
    public void getAllTickets();
    public void getTicketById(Scanner scanner);
    public void getTicketByConcertName(Scanner scanner);
    public void getTicketByDate(Scanner scanner);
    public void putTicketById(Scanner scanner);
    public void deleteTicketById(Scanner scanner);
    public void getDateWithMostSoldTickets();
}
