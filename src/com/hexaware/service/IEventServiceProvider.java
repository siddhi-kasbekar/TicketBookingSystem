package com.hexaware.service;

import java.util.List;

import com.hexaware.entity.Event;
import com.hexaware.entity.Venue;

public interface IEventServiceProvider {

    Event create_event(String event_name, String date, String time, int total_seats, float ticket_price, String event_type, Venue venue);

    List<Event> getEventDetails();


    int getAvailableNoOfTickets(String event_name);
}