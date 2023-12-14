package com.hexaware.repo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

import com.hexaware.entity.Booking;
import com.hexaware.entity.Customer;
import com.hexaware.entity.Event;
import com.hexaware.entity.Event.EventType;
import com.hexaware.entity.Venue;
import com.hexaware.util.DBUtil;

public class BookingSystemRepositoryImpl implements IBookingSystemRepository {

    @Override
    public Event create_event(String event_name, String event_date, String event_time, int total_seats, float ticket_price,
            String event_type, Venue venue) {
        try (Connection connection = DBUtil.getDBConn()) {
            // Insert new event into the Event table
            String insertEventQuery = "INSERT INTO Event (event_name, event_date, event_time, venue_id, total_seats, "
                    + "available_seats, ticket_price, event_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertEventQuery,
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, event_name);
                preparedStatement.setString(2, event_date);
                preparedStatement.setString(3, event_time);
                preparedStatement.setInt(4, venue.getVenueId());
                preparedStatement.setInt(5, total_seats);
                preparedStatement.setInt(6, total_seats); // Initially available seats = total seats
                preparedStatement.setFloat(7, ticket_price);
                preparedStatement.setString(8, event_type);

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    // Fetch the auto-generated event_id
                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int eventId = generatedKeys.getInt(1);

                            // Create and return the Event object
                            return new Event(eventId, event_name, LocalDate.parse(event_date), LocalTime.parse(event_time), venue, total_seats, total_seats,
                                    ticket_price, getEventTypeFromString(event_type), new ArrayList<>()) ;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Return null if event creation fails
    }
    private EventType getEventTypeFromString(String eventTypeString) {
        switch (eventTypeString.toUpperCase()) {
            case "MOVIE":
                return EventType.MOVIE;
            case "SPORTS":
                return EventType.SPORTS;
            case "CONCERT":
                return EventType.CONCERT;
            default:
                // Handle the case when the string doesn't match any EventType
                throw new IllegalArgumentException("Invalid event type: " + eventTypeString);
        }
    }


    @Override
    public List<Event> getEventDetails() {
        List<Event> events = new ArrayList<>();

        try (Connection connection = DBUtil.getDBConn()) {
            // Fetch all events from the Event table
            String selectEventsQuery = "SELECT * FROM Event";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectEventsQuery)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int eventId = resultSet.getInt("event_id");
                        String eventName = resultSet.getString("event_name");
                        String eventDate = resultSet.getString("event_date");
                        String eventTime = resultSet.getString("event_time");
                        int venueId = resultSet.getInt("venue_id");
                        int totalSeats = resultSet.getInt("total_seats");
                        int availableSeats = resultSet.getInt("available_seats");
                        float ticketPrice = resultSet.getFloat("ticket_price");
                        String eventType = resultSet.getString("event_type");

                        // Fetch venue details
                        Venue venue = getVenueDetails(venueId);

                        // Create and add the Event object to the list
                        events.add(new Event(eventId, eventName, LocalDate.parse(eventDate), LocalTime.parse(eventTime),
                                venue, totalSeats, availableSeats, ticketPrice, getEventTypeFromString(eventType), new ArrayList<>()));




                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public int getAvailableNoOfTickets(String event_name) {
        try (Connection connection = DBUtil.getDBConn()) {
            // Fetch available seats for the specified event from the Event table
            String selectAvailableSeatsQuery = "SELECT available_seats FROM Event WHERE event_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectAvailableSeatsQuery)) {
                preparedStatement.setString(1, event_name);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("available_seats");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0; // Return -1 if event not found or in case of an error
    }


    @Override
    public void calculate_booking_cost(int num_tickets) {
        // Implementation 
    }

    @Override
    public void book_tickets(String event_name, int num_tickets, List<Customer> customers) {
        // Implementation 
    }

    @Override
    public void cancel_booking(int booking_id) {
        // Implementation 
    }

    @Override
    public Booking get_booking_details(int booking_id) {
        // Implementation 
        return null;
    }

    // Helper method to fetch Venue details by venue_id
    private Venue getVenueDetails(int venueId) {
        try (Connection connection = DBUtil.getDBConn()) {
            // Fetch venue details from the Venue table
            String selectVenueQuery = "SELECT * FROM Venue WHERE venue_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectVenueQuery)) {
                preparedStatement.setInt(1, venueId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String venueName = resultSet.getString("venue_name");
                        String address = resultSet.getString("address");

                        // Create and return the Venue object
                        return new Venue(venueId, venueName, address);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Return null if venue details not found or in case of an error
    }
}
