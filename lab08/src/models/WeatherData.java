package models;

public class WeatherData {
    private final double temperature;
    private final String weatherCondition;
    private final String location;
    private final String dataSource;

    public WeatherData(double temperature, String weatherCondition, String location, String dataSource) {
        this.temperature = temperature;
        this.weatherCondition = weatherCondition;
        this.location = location;
        this.dataSource = dataSource;
    }

    @Override
    public String toString() {
        return String.format("Location: %s\nTemperature: %.2f°C\nCondition: %s\nSource: %s", location, temperature, weatherCondition, dataSource);
    }
}
