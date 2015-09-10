package org.droolsdemo.weatherforecast;

public class WeatherReport {

    public boolean isSunnyWeather(WeatherData input) {
        if (input.getAirPreasure() < 30 && input.getTemperature() > 20.5 && input.getWindSpeed() < 15) {
            return true;
        }
        return false;
    }
}
