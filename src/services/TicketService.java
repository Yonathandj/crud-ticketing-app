package services;

import connection.ConnectDatabase;

import java.sql.Date;
import java.util.UUID;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;

public class TicketService {
    public String addNewTicketService(String concertName, String venue, String date, String organizer, double price, double discount) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            PreparedStatement ps = connection.prepareStatement("INSERT INTO tickets (id, concert_name, venue, concert_date, organizer, ticket_code, price, discount) VALUES(?, ? ,? ,? , ?, ? ,? ,?)");

            String id = "ticket-" + UUID.randomUUID();
            String ticketCode = "ticketCode" + UUID.randomUUID();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate newDate = LocalDate.parse(date, formatter);

            ps.setString(1, id);
            ps.setString(2, concertName);
            ps.setString(3, venue);
            ps.setDate(4, Date.valueOf(newDate));
            ps.setString(5, organizer);
            ps.setString(6, ticketCode);
            ps.setDouble(7, price);
            ps.setDouble(8, discount);

            ps.executeUpdate();
            return id;

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return null;
    }
}
