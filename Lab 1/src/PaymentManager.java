import java.util.Scanner;

public class PaymentManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static PaymentMethod getPaymentMethod() {
        System.out.println("Select Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Digital Wallet");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                return handleCreditCardPayment();
            case "2":
                return handlePayPalPayment();
            case "3":
                return handleDigitalWalletPayment();
            default:
                System.out.println("Invalid payment method selected.");
                return getPaymentMethod();
        }
    }



    public static void handlePayment(Trip trip) {
        System.out.print("The calculated fare based on distance is " + trip.getFare() + "\n");
        System.out.print("Enter the amount you are paying: ");
        double amountPaid = Double.parseDouble(scanner.nextLine());
        System.out.println("Payment successful! You paid " + amountPaid + " for the fare of " + trip.getFare() + ".");
    }

    private static PaymentMethod handleCreditCardPayment() {
        System.out.print("Enter Card Number: ");
        int cardNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Card Holder Name: ");
        String cardHolderName = scanner.nextLine();
        return new CreditCardPayment(cardNumber, cardHolderName);
    }

    private static PaymentMethod handlePayPalPayment() {
        System.out.print("Enter PayPal Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter OTP: ");
        int otpPayPal = Integer.parseInt(scanner.nextLine());
        return new PayPalPayment(email, otpPayPal);
    }

    private static PaymentMethod handleDigitalWalletPayment() {
        System.out.print("Enter Wallet ID: ");
        String walletId = scanner.nextLine();
        System.out.print("Enter OTP: ");
        int otpWallet = Integer.parseInt(scanner.nextLine());
        return new DigitalWalletPayment(walletId, otpWallet);
    }
}
