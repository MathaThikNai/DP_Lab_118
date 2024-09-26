public class PayPalPayment implements PaymentMethod {
    private String email;
    private int otp;

    // Constructor
    public PayPalPayment(String email, int otp) {
        this.email = email;
        this.otp = otp;
    }

    // Implementing IPaymentMethod interface
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of " + amount + ".");
        System.out.println("Email: " + email + ", OTP: " + otp);
    }
}
