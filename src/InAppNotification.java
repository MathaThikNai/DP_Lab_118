public class InAppNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("In-App Notification: " + message);
    }
}
