package App;



import com.hexaware.entity.Customer;
import com.hexaware.entity.Event;
import com.hexaware.entity.Venue;
import com.hexaware.repo.BookingSystemRepositoryImpl;
import com.hexaware.repo.IBookingSystemRepository;

import java.util.List;
import java.util.Scanner;

public class TicketBookingSystemRepository {

    private static final Scanner scanner = new Scanner(System.in);
    private static final IBookingSystemRepository bookingSystemRepository = new BookingSystemRepositoryImpl();

    public static void main(String[] args) {
        System.out.println("Welcome to the Ticket Booking System!");

        boolean exit = false;
        while (!exit) {
            printMenu();
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "create_event":
                    createEvent();
                    break;
                case "book_tickets":
                    bookTickets();
                    break;
                case "cancel_tickets":
                    cancelTickets();
                    break;
                case "get_available_seats":
                    getAvailableSeats();
                    break;
                case "get_event_details":
                    getEventDetails();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

        System.out.println("Thank you for using the Ticket Booking System!");
    }

    private static void printMenu() {
        System.out.println("\nAvailable Commands:");
        System.out.println("1. create_event");
        System.out.println("2. book_tickets");
        System.out.println("3. cancel_tickets");
        System.out.println("4. get_available_seats");
        System.out.println("5. get_event_details");
        System.out.println("6. exit");
        System.out.print("Enter your choice: ");
    }

    private static void createEvent() {
        // Implementation for creating an event
        // You can take input from the user for event details
    }

    private static void bookTickets() {
        // Implementation for booking tickets
        // You can take input from the user for booking details
    }

    private static void cancelTickets() {
        // Implementation for canceling tickets
        // You can take input from the user for cancellation details
    }

    private static void getAvailableSeats() {
        // Implementation for getting available seats
        // You can take input from the user for event details
    }

    private static void getEventDetails() {
        // Implementation for getting event details
        // You can display the list of events from the repository
        List<Event> events = bookingSystemRepository.getEventDetails();
        for (Event event : events) {
            System.out.println(event.toString()); // Adjust the toString method in the Event class
        }
    }
}
