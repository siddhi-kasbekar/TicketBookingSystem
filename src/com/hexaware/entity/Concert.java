package com.hexaware.entity;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Concert extends Event {
    private String artist;
    private String type;

    // Constructors
    public Concert() {
        // Default constructor
    }

    public Concert(String eventName, LocalDate eventDate, LocalTime eventTime,
            Venue venue, int totalSeats, int availableSeats, float ticketPrice,
            String artist, String type) {
 super(0, eventName, eventDate, eventTime, venue, totalSeats, availableSeats,
         ticketPrice, EventType.CONCERT, new ArrayList<>());
 this.artist = artist;
 this.type = type;
}

    @Override
    public String displayEventDetails() {
        return super.displayEventDetails() +
                "Artist: " + artist + "\n" +
                "Type: " + type + "\n";
    }
}
