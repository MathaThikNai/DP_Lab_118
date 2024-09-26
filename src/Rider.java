public class Rider extends User {
    private PaymentMethod preferredPaymentMethod;

    public Rider(int id, String name, String location, PaymentMethod preferredPaymentMethod) {
        super(id, name, location);
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public PaymentMethod getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public void setPreferredPaymentMethod(PaymentMethod preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public void requestRide(String pickupLocation, String dropOffLocation, RideType rideType) {
        System.out.println(getName() + " has requested a " + rideType + " ride from " + pickupLocation + " to " + dropOffLocation + ".");// admin dekhte parbe
    }

    public void rateDriver(Driver driver, double rating) {
        driver.updateRating(rating);
        System.out.println(getName() + " rated " + driver.getName() + " with " + rating + " stars.");
    }

    public void makePayment(Trip trip) {
        preferredPaymentMethod.processPayment(trip.getFare());
    }

    // Method to change the payment method dynamically
    public void changePaymentMethod(PaymentMethod newMethod) {
        preferredPaymentMethod = newMethod;
        //System.out.println(getName() + " has switched to a new payment method.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Rider: " + getName() + ", Location: " + getLocation() + ", Rating: " + getRating());
    }
}
