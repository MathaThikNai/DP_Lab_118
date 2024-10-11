import java.util.Scanner;

public class RiderManager {
    private final Scanner scanner = new Scanner(System.in);

    // Initializes the rider by collecting necessary details
    public Rider initializeRider() {
        System.out.print("Enter Rider ID: ");
        int riderId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Rider Name: ");
        String riderName = scanner.nextLine();

        return new Rider(riderId, riderName, null, null);
    }

    // Changes the rider's payment method
    public void changePaymentMethod(Rider rider) {
        PaymentMethod paymentMethod = PaymentManager.getPaymentMethod();
        rider.changePaymentMethod(paymentMethod);
        System.out.println(rider.getName() + " has switched to a new payment method.");
    }

    // Asks if the rider wants to change the payment method during the ride
    public boolean changePaymentMethodDuringRide() {
        System.out.print("Do you want to change your payment method? (yes/no): ");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }
}
