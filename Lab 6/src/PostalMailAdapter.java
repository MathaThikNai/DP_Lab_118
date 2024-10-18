public class PostalMailAdapter implements NotificationSender {
    private PostalMailAPI postalMailAPI;

    public PostalMailAdapter(PostalMailAPI postalMailAPI) {
        this.postalMailAPI = postalMailAPI;
    }

    @Override
    public void send(String recipient, String message) {
        // Assume you split recipient into name, address, and postal code for the postal mail.
        String[] recipientDetails = recipient.split(",");
        String name = recipientDetails[0];
        String address = recipientDetails[1];
        String postalCode = recipientDetails[2];

        postalMailAPI.sendPostalMail(name, address, postalCode, message);
    }
}
