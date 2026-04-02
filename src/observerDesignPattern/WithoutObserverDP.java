package observerDesignPattern;

class WeatherStationWODP{
    private float temperature;

    PhoneDisplayWODP phoneDisplayWODP = new PhoneDisplayWODP();
    TvDisplayWODP tvDisplayWODP = new TvDisplayWODP();

    public void setTemperature(float temperature){
        this.temperature = temperature;
        notifyDisplays();
    }

    public void notifyDisplays(){
        // Direct dependency on concrete display classes
        phoneDisplayWODP.update(temperature);
        tvDisplayWODP.update(temperature);
    }
}

class PhoneDisplayWODP{
    public void update(float temperature){
        System.out.println("Phone Display: Temperature is " + temperature + "°C");
    }
}

class TvDisplayWODP{
    public void update(float temperature){
        System.out.println("TV Display: Temperature is " + temperature + "°C");
    }
}

public class WithoutObserverDP {
    public static void main(String[] args){
        WeatherStationWODP weatherStationWODP = new WeatherStationWODP();
        weatherStationWODP.setTemperature(45.0f);
    }
}
