package com.hexaware.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sport extends Event {
    private String sportName;
    private String team1;
    private String team2;

 // Constructors
    public Sport() {
        // Default constructor
    }

    public Sport(String eventName, LocalDate eventDate, LocalTime eventTime,
            Venue venue, int totalSeats, int availableSeats, float ticketPrice,
            String sportName, String teamsName) {
   super(0, eventName, eventDate, eventTime, venue, totalSeats, availableSeats,
           ticketPrice, EventType.SPORTS, new ArrayList<>());
        this.sportName = sportName;
        this.team1 = team1;
        this.team2 = team2;

    }






    @Override
    public String displayEventDetails() {
        return super.displayEventDetails() +
                "Sport: " + sportName + "\n" +
                "Team1: " + team1 + "\n"+
                "Team2: " + team2 + "\n";
    }
}
