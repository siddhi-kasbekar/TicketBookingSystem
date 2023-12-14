package com.hexaware.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.*;

public class EventServiceProviderImpl implements IEventServiceProvider {

    private List<Event> events;

    public EventServiceProviderImpl() {
        this.events = new ArrayList<>();
    }

    @Override
    public Event create_event(String event_name, String date, String time, int total_seats,
                              float ticket_price, String event_type, Venue venue) {
        Event.EventType eventType = Event.EventType.valueOf(event_type);
        Event newEvent = null;

        switch (eventType) {
            case MOVIE:
                newEvent = new Movie(event_name, LocalDate.parse(date), LocalTime.parse(time),
                        venue, total_seats,  ticket_price, "Action", "Actor1", "Actress1");
                break;
            case SPORTS:
                newEvent = new Sport(event_name, LocalDate.parse(date), LocalTime.parse(time),
                        venue, total_seats, ticket_price,  "Football", "TeamA", "TeamB");
                break;
            case CONCERT:
                newEvent = new Concert(event_name, LocalDate.parse(date), LocalTime.parse(time),
                        venue, total_seats,  ticket_price, "Artist1", "Rock");
                break;
        }

        // Add the new event to the list of events
        events.add(newEvent);

        return newEvent;
    }

    @Override
    public List<Event> getEventDetails() {
        return events;
    }

    @Override
    public int getAvailableNoOfTickets(String event_name) {
        for (Event event : events) {
            if (event.getEventName().equals(event_name)) {
                return event.getAvailableSeats();
            }
        }
        return -1; // Event not found
    }
}
