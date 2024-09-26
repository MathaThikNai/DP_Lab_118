import java.util.Scanner;

public class DriverManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static void rateDriver(Driver driver, Rider rider) {
        System.out.print("Rate the driver (1 to 5): ");
        double rating = Double.parseDouble(scanner.nextLine());
        driver.updateRating(rating);
        System.out.println(rider.getName() + " rated " + driver.getName() + " with " + rating + " stars.");
    }
}
