package com.hexaware.repo;


import com.hexaware.entity.Event;
import com.hexaware.entity.Venue;
import com.hexaware.entity.Customer;

import java.util.List;

import com.hexaware.entity.Booking;

public interface IBookingSystemRepository {

    Event create_event(String event_name, String date, String time, int total_seats,
                       float ticket_price, String event_type, Venue venue);

    List<Event> getEventDetails();

    int getAvailableNoOfTickets(String event_name);

    void calculate_booking_cost(int num_tickets);

    void book_tickets(String eventname, int num_tickets, List<Customer> listOfCustomer);

    void cancel_booking(int booking_id);

    Booking get_booking_details(int booking_id);
}
