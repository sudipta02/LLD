package weather_station_observer.classes;

import weather_station_observer.interfaces.Subject;
import weather_station_observer.interfaces.Observer;
import java.util.List;
import java.util.ArrayList;

public class WeatherData implements Subject{
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    public float getTemperature() {
        return temperature;
    }
    public float getHumidity() {
        return humidity;
    }
    public WeatherData() {
        observers = new ArrayList<Observer>();
    }
    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.update();
        }
    }
    public void measurementsChanged(){
        notifyObservers();
    }
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;
        measurementsChanged();
    }
}
