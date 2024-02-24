package implementations.repositories;

import java.sql.ResultSet;

public interface TicketRepositoryImplementation {
    public String addNewTicketService(String concertName, String venue, String date, String organizer, double price, double discount);
    public ResultSet getAllTicketsService();
    public ResultSet getTicketByIdService(String id);
    public ResultSet getTicketByConcertNameService(String concertName);
    public ResultSet getTicketByDateService(String date);
    public int updateTicketService(String id, String concertName, String venue, String date, String organizer, double price, double discount);
    public int deleteTicketByIdService(String id);
    public ResultSet getDateWithMostSoldTickets();
    public ResultSet checkExistenceTicket(String id);
}
