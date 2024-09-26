public class CreditCardPayment implements PaymentMethod {
    private int cardNumber;
    private String cardHolderName;

    // Constructor
    public CreditCardPayment(int cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    // Implementing IPaymentMethod interface
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of " + amount + ".");
        System.out.println("Card Number: " + cardNumber + ", Card Holder: " + cardHolderName);
    }

    // Getters for cardNumber and cardHolderName if needed
    public int getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }
}
