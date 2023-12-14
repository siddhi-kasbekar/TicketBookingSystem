package com.hexaware.entity;

//com.hexaware.entity.Venue.java

public class Venue {
    private int venueId;
 private String venueName;
 private String address;

 // Default constructor
 public Venue() {
 }

 // Overloaded constructor
 public Venue(int venueId, String venueName, String address) {
     this.venueId = venueId;
     this.venueName = venueName;
     this.address = address;
 }

 // Getter and setter methods
 public int getVenueId() {
     return venueId;
 }

 public void setVenueId(int venueId) {
     this.venueId = venueId;
 }
 public String getVenueName() {
     return venueName;
 }

 public void setVenueName(String venueName) {
     this.venueName = venueName;
 }

 public String getAddress() {
     return address;
 }

 public void setAddress(String address) {
     this.address = address;
 }
 

 // Display venue details method
 public String displayVenueDetails() {
	    StringBuilder details = new StringBuilder();
	    details.append("Venue Name: ").append(venueName).append("\n");
	    details.append("Address: ").append(address).append("\n");
	    return details.toString();
	}

}
