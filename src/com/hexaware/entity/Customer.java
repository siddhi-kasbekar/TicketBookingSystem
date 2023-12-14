package com.hexaware.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private String email;
    private String phoneNumber;

    // Default constructor
    public Customer() {
    }

    // Overloaded constructor with parameters
    public Customer(String customerName, String email, String phoneNumber) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter methods for customerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Getter and setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter methods for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String displayCustomerDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Customer Name: ").append(customerName).append("\n");
        details.append("Email: ").append(email).append("\n");
        details.append("Phone Number: ").append(phoneNumber).append("\n");
        
        return details.toString();
    }

//    public static void main(String[] args) {
//        // Example usage
//        List<Customer> customers = new ArrayList<>();
//
//        Customer customer1 = new Customer("John Doe", "john@example.com", "123-456-7890");
//        Customer customer2 = new Customer("Jane Doe", "jane@example.com", "987-654-3210");
//
//        customers.add(customer1);
//        customers.add(customer2);
//
//        for (Customer customer : customers) {
//            System.out.println(customer.displayCustomerDetails());
//            System.out.println("----------------------");
//        }
//    }
}

