package weather_station_observer.classes;

import weather_station_observer.interfaces.DisplayElement;
import weather_station_observer.interfaces.Observer;

public class ForecastDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    //Here, the Observer is pulling the data that it needs (temperature and humidity)
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    public void display() {
        System.out.println("Forecast: " + temperature + " degrees and " + humidity + "% humidity");
    }
}
