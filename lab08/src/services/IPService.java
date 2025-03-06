package services;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class IPService {
    public static String getCityByIP() {
        String city = null; // Initialize city to store the result
        try {
            // Specify the API endpoint
            URL url = new URL("https://ipwhois.app/json/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0"); // Best practice to include User-Agent

            // Check for a successful response code
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Scanner sc = new Scanner(conn.getInputStream());
                StringBuilder response = new StringBuilder();

                // Read the API response
                while (sc.hasNext()) {
                    response.append(sc.nextLine());
                }
                sc.close();

                // Parse the JSON response to extract the city
                JSONObject jsonResponse = new JSONObject(response.toString());
                city = jsonResponse.optString("city", "Unknown City"); // Default to "Unknown City" if not present
            } else {
                System.err.println("Failed to get IP data. Response Code: " + conn.getResponseCode());
                System.err.println("Response Message: " + conn.getResponseMessage());
            }
        } catch (Exception e) {
            System.err.println("Check your default key. Error fetching location data: " + e.getMessage());
        }
        return city; // Return the city, or null if not fetched
    }
}
