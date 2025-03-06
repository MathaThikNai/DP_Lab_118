package utils;

import models.WeatherData;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    private static CacheManager instance;
    private final Map<String, CacheEntry> cache = new HashMap<>();

    private CacheManager() {}

    public static synchronized CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    public WeatherData getCachedWeather(String location) {
        CacheEntry entry = cache.get(location);
        if (entry != null && entry.isValid()) {
            return entry.weatherData;
        }
        return null;
    }

    public void cacheWeather(String location, WeatherData weatherData) {
        cache.put(location, new CacheEntry(weatherData, LocalDateTime.now().plusMinutes(10)));
    }

    private static class CacheEntry {
        WeatherData weatherData;
        LocalDateTime expiry;

        CacheEntry(WeatherData weatherData, LocalDateTime expiry) {
            this.weatherData = weatherData;
            this.expiry = expiry;
        }

        boolean isValid() {
            return LocalDateTime.now().isBefore(expiry);
        }
    }
}
