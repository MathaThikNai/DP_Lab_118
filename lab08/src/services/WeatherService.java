package services;

import models.WeatherData;

public interface WeatherService {
    WeatherData getWeather(String location);
}
