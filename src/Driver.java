public class Driver extends User {
    private String vehicleType;
    private boolean isAvailable;

    public Driver(int id, String name, String location, String vehicleType) {
        super(id, name, location);
        this.vehicleType = vehicleType;
        this.isAvailable = true;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void acceptRide(Trip trip) {
        if (isAvailable) {
            trip.assignDriver(this);
            System.out.println(getName() + " has accepted the ride.");
        }
    }

    public void startTrip(Trip trip) {
        trip.startTrip();
    }

    public void completeTrip(Trip trip) {
        trip.completeTrip();
    }

    public void updateRating(double rating) {
        setRating((getRating() + rating) / 2);
    }

    public void rateRider(Rider rider, double rating) {
        System.out.println(getName() + " rated " + rider.getName() + " with " + rating + " stars.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Driver: " + getName() + ", Vehicle Type: " + vehicleType + ", Location: " + getLocation() + ", Rating: " + getRating());
    }
}
