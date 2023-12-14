package com.hexaware.entity;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Movie extends Event {
    private String genre;
    private String actorName;
    private String actressName;

    // Constructors
    public Movie() {
        // Default constructor
    }

    public Movie(String eventName, LocalDate eventDate, LocalTime eventTime,
            Venue venue, int totalSeats, int availableSeats, float ticketPrice,
            String genre, String actorName, String actressName) {
   super(0, eventName, eventDate, eventTime, venue, totalSeats, availableSeats,
           ticketPrice, EventType.MOVIE, new ArrayList<>());
   this.genre = genre;
   this.actorName = actorName;
   this.actressName = actressName;
}

    @Override
    public String displayEventDetails() {
        return super.displayEventDetails() +
                "Genre: " + genre + "\n" +
                "Actor: " + actorName + "\n" +
                "Actress: " + actressName + "\n";
    }
}
