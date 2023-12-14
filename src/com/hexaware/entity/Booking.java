package com.hexaware.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private static int bookingIdCounter = 1; // Counter for generating booking IDs
    private int bookingId;
    private List<Customer> customers;
    private Event event;
    private int numTickets;
    private double totalCost;
    private LocalDateTime bookingDate;

    // Constructors
    public Booking() {
        // Default constructor
        this.bookingId = bookingIdCounter++;
        this.bookingDate = LocalDateTime.now();
        this.customers = new ArrayList<>();
    }

    public Booking(List<Customer> customers, Event event, int numTickets) {
        this();
        this.customers = customers;
        this.event = event;
        this.numTickets = numTickets;
        // Calculate total cost based on the number of tickets and event ticket price
        this.totalCost = numTickets * event.getTicketPrice();
    }

    // Getter and Setter methods
    public int getBookingId() {
        return bookingId;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    // Display booking details
    public String displayBookingDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Booking ID: ").append(bookingId).append("\n");
        details.append("Booking Date: ").append(bookingDate).append("\n");
        details.append("Event: ").append(event.getEventName()).append("\n");
        details.append("Number of Tickets: ").append(numTickets).append("\n");
        details.append("Total Cost: ").append(totalCost).append("\n");
        details.append("Customers:").append("\n");
        for (Customer customer : customers) {
            details.append("  - ").append(customer.getCustomerName()).append("\n");
        }
        return details.toString();
    }
}
