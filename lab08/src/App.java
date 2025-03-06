import models.WeatherData;
import services.IPService;
import services.OpenWeatherService;
import utils.CacheManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OpenWeatherService openWeatherService = new OpenWeatherService("443424d2dc53852a6928b207bc4f4d9f"); // Replace with your OpenWeather API key
        CacheManager cache = CacheManager.getInstance();

        System.out.println("Welcome to the Weather Console Application!");
        System.out.println("Choose an option to get weather data:");
        System.out.println("1. By IP");
        System.out.println("2. By City");

        int choice = scanner.nextInt();
        scanner.nextLine();

        String city = null;

        if (choice == 1) {
            city = IPService.getCityByIP();
//            System.out.println(city);
        } else if (choice == 2) {
            System.out.println("Enter the city name:");
            city = scanner.nextLine();
//            System.out.println(city);
        } else {
            System.out.println("Invalid choice. Exiting.");
            return;
        }

        WeatherData weatherData = cache.getCachedWeather(city);
        if (weatherData == null && city != null) {
            weatherData = openWeatherService.getWeather(city);
            if (weatherData != null) {
                cache.cacheWeather(city, weatherData);
            }
        }

        if (weatherData != null) {
            System.out.println(weatherData);
        } else {
            System.out.println("Failed to fetch weather data.");
        }
    }
}
