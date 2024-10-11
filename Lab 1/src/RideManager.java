import java.util.Scanner;

public class RideManager {
    private final Scanner scanner = new Scanner(System.in);
    private final RiderManager riderManager = new RiderManager();

    // Requests a ride for the rider, assigning a driver and starting the trip
    public Trip requestRide(Rider rider) {
        // Get ride details
        String pickupLocation = getInput("Enter Pickup Location: ");
        String dropOffLocation = getInput("Enter Drop-off Location: ");
        double distance = Double.parseDouble(getInput("Enter Distance (in km): "));

        // Select ride type
        RideType rideType = getRideType();

        // Set initial payment method for the rider
        rider.changePaymentMethod(PaymentManager.getPaymentMethod());

        // Create a new trip
        Trip trip = new Trip(1, pickupLocation, dropOffLocation, rideType, distance);

        // Assign a driver to the trip
        Driver driver = new Driver(1, "Driver", "Current Location", "Luxury Car");
        trip.assignDriver(driver);

        // Start the trip
        trip.startTrip();

        System.out.println("Journey is in progress...");

        // Offer to change payment method during the ride
        if (riderManager.changePaymentMethodDuringRide()) {
            riderManager.changePaymentMethod(rider);
        }

        return trip;
    }

    // Completes the ride, processes payment, and handles driver rating
    public void completeRide(Trip trip, Rider rider) {
        // Complete the trip
        trip.completeTrip();

        // Handle the payment
        PaymentManager.handlePayment(trip);

        // Rate the driver after trip completion
        DriverManager.rateDriver(trip.getDriver(), rider);

        // Display completion message
        displayCompletionMessage(trip);
    }

    // Prompts the user to select a ride type from a list of options
    private RideType getRideType() {
        System.out.println("Select Ride Type:");
        System.out.println("1. Carpool");
        System.out.println("2. Luxury");
        System.out.println("3. Bike");
        System.out.print("Enter your choice: ");
        return RideType.valueOf(scanner.nextLine().toUpperCase());
    }

    // Utility method to get input from the user
    private String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Displays the completion message after the ride ends
    private void displayCompletionMessage(Trip trip) {
        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("You have completed your journey from " + trip.getPickupLocation() + " to " + trip.getDropOffLocation() +
                " and paid " + trip.getFare() + ".");
        System.out.println("-----------------------------------------------------------------------------------");
    }
}
