public class DigitalWalletPayment implements PaymentMethod {
    private String walletId;
    private int otp;

    // Constructor
    public DigitalWalletPayment(String walletId, int otp) {
        this.walletId = walletId;
        this.otp = otp;
    }

    // Implementing IPaymentMethod interface
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Digital Wallet payment of " + amount + ".");
        System.out.println("Wallet ID: " + walletId + ", OTP: " + otp);
    }

    // Getters if needed
    public String getWalletId() {
        return walletId;
    }

    public int getOtp() {
        return otp;
    }
}
