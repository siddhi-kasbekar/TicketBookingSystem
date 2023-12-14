package com.hexaware.service;

import com.hexaware.entity.Customer;

import java.util.List;

public interface IBookingSystemServiceProvider {

    void calculateBookingCost(int noOfTickets);

    void bookTickets(String eventName, int noOfTickets, List<Customer> customers);

    void cancelBooking(int bookingId);

    void getBookingDetails(int bookingId);
}
