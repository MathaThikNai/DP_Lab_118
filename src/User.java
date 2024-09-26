public abstract class User {
    private int id;
    private String name;
    private String location;
    private double rating;

    public User(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = 5.0; // Default rating for a new user
    }

    // Getters and setters for the fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayInfo();
}
