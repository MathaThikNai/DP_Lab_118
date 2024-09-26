public class RideSharingApp {
    private final RiderManager riderManager;
    private final RideManager rideManager;
    private final PaymentManager paymentManager;
    private final DriverManager driverManager;

    public RideSharingApp() {
        this.riderManager = new RiderManager();
        this.rideManager = new RideManager();
        this.paymentManager = new PaymentManager();
        this.driverManager = new DriverManager();
    }

    public void start() {
        System.out.println("---------------------------------------------------");
        System.out.println("Ride-Sharing App");
        System.out.println("---------------------------------------------------");
        Rider rider = riderManager.initializeRider();
        Trip trip = rideManager.requestRide(rider);
        rideManager.completeRide(trip, rider);
    }

    public static void main(String[] args) {
        RideSharingApp app = new RideSharingApp();
        app.start();//app is starting from here.
    }
}
