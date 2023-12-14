package com.hexaware.service;

//BookingSystemServiceProviderImpl.java


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.entity.Booking;
import com.hexaware.entity.Customer;
import com.hexaware.entity.Event;
import com.hexaware.entity.Venue;

public class BookingSystemServiceProviderImpl implements IBookingSystemServiceProvider{
	public ArrayList<Event> events;
	public ArrayList<Booking> bookings;
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void calculateBookingCost(int noOfTickets) {
		System.out.println("Enter your event name: ");
		String eventName = sc.nextLine();
		
		for (Event e : events) {
			if (e.getEventName().equalsIgnoreCase(eventName)) {
				System.out.println((e.getTicketPrice()*noOfTickets));
			}
		}
	}
	
	@Override
	public void bookTickets(String eventName,int noOfTickets,List<Customer> customers) {
		List<Customer> bookedCustomers = new ArrayList<>();
		Event selectedEvent = findEventByName(eventName);
		
		System.out.println("Enter your name: ");
		String customerName=sc.nextLine();
		System.out.println("Enter your email:");
		String customerEmail=sc.nextLine();
		System.out.println("Enter your phone number: ");
		String customerPhoneNumber = sc.next(); // Assuming phoneNumber is a string
		for (int i = 0; i < noOfTickets; i++) {
		    Customer customer = new Customer(customerName, customerEmail, customerPhoneNumber);
		    bookedCustomers.add(customer);
		}


		
		Booking booking = new Booking(bookedCustomers, selectedEvent, noOfTickets);
		bookings.add(booking);
		
		for (Event e : events) {
			if (e.getEventName().equalsIgnoreCase(eventName)) {
				if(e.getAvailableSeats()>=noOfTickets) {
					e.setAvailableSeats(e.getAvailableSeats()+noOfTickets);
					System.out.println("Your booking is successful");
					System.out.println(noOfTickets+" have been booked successfully.");
				}
			}
		}
	}
	
	@Override
	public void cancelBooking(int bookingId) {
		Booking b=findBookingById(bookingId);
		
		if(b!=null) {
			Event event=b.getEvent();
			int noOfTickets=b.getNumTickets();
				
			event.setAvailableSeats(event.getAvailableSeats()-noOfTickets);
			bookings.remove(b);
		}
	}
	
	@Override
	public void getBookingDetails(int bookingId) {
		Booking b = findBookingById(bookingId);
		
		b.displayBookingDetails();
	}
	
	public Event findEventByName(String eventName) {
        for (Event event : events) {
            if (event.getEventName().equalsIgnoreCase(eventName)) {
                return event;
            }
        }
        System.out.println("Event not found.");
        return null;
    }
	
	public Booking findBookingById(int bookingId) {
		for (Booking booking : bookings) {
		    if (booking.getBookingId() == bookingId) {
		        return booking;
		    }
		}
	    return null;
	}
}
