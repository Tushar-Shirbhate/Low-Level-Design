package observerDesignPattern;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(float temperature);
}

interface Subject{
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class WeatherStation implements Subject{
    private final List<Observer> observers = new ArrayList<>();
    private float temperature;

    @Override
    public void registerObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(temperature);
        }
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
        notifyObservers();
    }
}

class PhoneDisplay implements Observer{
    @Override
    public void update(float temperature){
        System.out.println("Phone Display: Temperature is " + temperature + "°C");
    }
}

class TvDisplay implements Observer{
    @Override
    public void update(float temperature){
        System.out.println("TV Display: Temperature is " + temperature + "°C");
    }
}

public class ObserverDP {
    public static void main(String[] args){
        WeatherStation weatherStation = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        TvDisplay tvDisplay = new TvDisplay();

        weatherStation.registerObserver(phoneDisplay);
        weatherStation.registerObserver(tvDisplay);

        weatherStation.setTemperature(45.5f);

        weatherStation.removeObserver(tvDisplay);

        weatherStation.setTemperature(40.8f);
    }
}
