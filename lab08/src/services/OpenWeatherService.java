package services;

import models.WeatherData;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class OpenWeatherService implements WeatherService {
    private final String apiKey;

    public OpenWeatherService(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public WeatherData getWeather(String location) {
        if (location == null || location.isEmpty()) {
            System.out.println("Invalid location: " + location);
            return null;
        }

        String apiUrl = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s", location, apiKey);
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                Scanner sc = new Scanner(conn.getInputStream());
                StringBuilder response = new StringBuilder();
                while (sc.hasNext()) {
                    response.append(sc.nextLine());
                }
                sc.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                double temp = jsonResponse.getJSONObject("main").getDouble("temp");
                String weather = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");
                String cityName = jsonResponse.getString("name");

                return new WeatherData(temp, weather, cityName, "OpenWeather");
            } else {
                System.out.println("OpenWeather API Response Code: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.out.println("Error fetching data from OpenWeather: " + e.getMessage());
        }
        return null;
    }
}
