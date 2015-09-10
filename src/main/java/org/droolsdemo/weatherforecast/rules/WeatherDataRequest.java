package org.droolsdemo.weatherforecast.rules;

import org.droolsdemo.weatherforecast.WeatherData;

public class WeatherDataRequest {

    private WeatherData input;

    public boolean isSunnyWeather;

    public WeatherDataRequest(WeatherData input) {
        this.input = input;
    }

    public float getTemperature() {
        return input.getTemperature();
    }

    public float getAirPreasure() {
        return input.getAirPreasure();
    }

    public float getWindSpeed() {
        return input.getWindSpeed();
    }

}
