package com.hexaware.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
	private int eventId;
    private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private Venue venue;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;
    private EventType eventType;
    private List<Booking> bookings;
    public enum EventType {
        MOVIE,
        CONCERT,
        SPORTS
    }

    // Default constructor
    public Event() {
    }

    // Overloaded constructor
    public Event(int eventId, String eventName, LocalDate eventDate, LocalTime eventTime,
            Venue venue, int totalSeats, int availableSeats, float ticketPrice,
            EventType eventType, List<Booking> bookings) {
   this.eventId = eventId;
   this.eventName = eventName;
   this.eventDate = eventDate;
   this.eventTime = eventTime;
   this.venue = venue;
   this.totalSeats = totalSeats;
   this.availableSeats = availableSeats; 
   this.ticketPrice = ticketPrice;
   this.eventType = eventType;
   this.bookings = bookings != null ? bookings : new ArrayList<>();
}

    // Getter and setter methods for all attributes

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
    public List<Booking> getBookings() {
        return bookings;
    }

    // Setter for bookings
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings != null ? bookings : new ArrayList<>();
    }

    public String displayEventDetails() {
        return "Event Name: " + eventName + "\n" +
                "Event Date: " + eventDate + "\n" +
                "Event Time: " + eventTime + "\n" +
                "Venue: " + venue.displayVenueDetails() + "\n" +
                "Total Seats: " + totalSeats + "\n" +
                "Available Seats: " + availableSeats + "\n" +
                "Ticket Price: " + ticketPrice + "\n" +
                "Event Type: " + eventType + "\n";
    }
}
