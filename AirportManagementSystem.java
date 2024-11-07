import java.util.ArrayList;
import java.util.List;

// Flight Class
class Flight {
    // Private attributes
    private String flightNumber;
    private String destination;
    private String departureTime;
    private String arrivalTime;

    // Constructor
    public Flight(String flightNumber, String destination, String departureTime, String arrivalTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Private method to check if the flight is upcoming
    private boolean isUpcoming() {
        // For simplicity, assume departure time is in "HH:mm" format
        // This method can be improved with date/time parsing and current time check
        return departureTime.compareTo(arrivalTime) < 0;
    }

    // Public methods to update departure and arrival times
    public void updateDepartureTime(String newDepartureTime) {
        this.departureTime = newDepartureTime;
    }

    public void updateArrivalTime(String newArrivalTime) {
        this.arrivalTime = newArrivalTime;
    }

    // Public method to display the details of the flight
    public void displayFlightDetails() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Destination: " + destination);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time: " + arrivalTime);
        System.out.println("-----------------------------");
    }

    // Public getter for flight number
    public String getFlightNumber() {
        return flightNumber;
    }

    // Public method to check if the flight is upcoming (used by Airport class)
    public boolean checkIfUpcoming() {
        return isUpcoming();
    }
}

// Airport Class
class Airport {
    // Private attributes
    private String airportName;
    private List<Flight> flights;

    // Constructor
    public Airport(String airportName) {
        this.airportName = airportName;
        this.flights = new ArrayList<>();
    }

    // Private method to find a flight by its flight number
    private Flight findFlightByNumber(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    // Public method to add a flight to the airport
    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added: " + flight.getFlightNumber());
    }

    // Public method to remove a flight from the airport by its flight number
    public void removeFlight(String flightNumber) {
        Flight flight = findFlightByNumber(flightNumber);
        if (flight != null) {
            flights.remove(flight);
            System.out.println("Flight removed: " + flightNumber);
        } else {
            System.out.println("Flight not found: " + flightNumber);
        }
    }

    // Public method to return a list of upcoming flights
    public void displayUpcomingFlights() {
        System.out.println("Upcoming Flights:");
        for (Flight flight : flights) {
            if (flight.checkIfUpcoming()) {
                flight.displayFlightDetails();
            }
        }
    }

    // Public method to return a list of completed flights
    public void displayCompletedFlights() {
        System.out.println("Completed Flights:");
        for (Flight flight : flights) {
            if (!flight.checkIfUpcoming()) {
                flight.displayFlightDetails();
            }
        }
    }

    // Public method to display details of all flights at the airport
    public void displayAllFlights() {
        System.out.println("All Flights at " + airportName + ":");
        for (Flight flight : flights) {
            flight.displayFlightDetails();
        }
    }
}

// Main class to run the program
public class AirportManagementSystem {

    public static void main(String[] args) {
        // Create an instance of the Airport class
        Airport airport = new Airport("Dehradun International Airport");

        // Create some flight instances
        Flight flight1 = new Flight("AI101", "New Delhi", "08:00", "10:00");
        Flight flight2 = new Flight("UK302", "Mumbai", "09:30", "12:30");
        Flight flight3 = new Flight("SG509", "Bengaluru", "11:00", "14:00");

        // Add flights to the airport
        airport.addFlight(flight1);
        airport.addFlight(flight2);
        airport.addFlight(flight3);

        // Display all flights
        airport.displayAllFlights();

        // Update a flight's departure and arrival time
        flight1.updateDepartureTime("07:45");
        flight1.updateArrivalTime("09:45");

        // Display all flights again after the update
        System.out.println("\nAfter updating flight timings:");
        airport.displayAllFlights();

        // Remove a flight
        airport.removeFlight("UK302");

        // Display remaining flights
        System.out.println("\nAfter removing flight UK302:");
        airport.displayAllFlights();

        // Display upcoming and completed flights
        airport.displayUpcomingFlights();
        airport.displayCompletedFlights();
    }
}
