package weather_station_observer;

import weather_station_observer.classes.CurrentConditionsDisplay;
import weather_station_observer.classes.ForecastDisplay;
import weather_station_observer.classes.WeatherData;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30);
        weatherData.setMeasurements(78, 90, 29);
    }
    
}
