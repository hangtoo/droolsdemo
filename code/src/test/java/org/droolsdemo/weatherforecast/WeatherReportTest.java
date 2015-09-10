package org.droolsdemo.weatherforecast;

import org.junit.Assert;
import org.junit.Test;

public class WeatherReportTest {

    @Test
    public void testIsSunnyWeather() {
        WeatherReport cut = new WeatherReport();

        WeatherData input = getTestData();

        Assert.assertTrue(cut.isSunnyWeather(input));
    }

    public WeatherData getTestData() {
        WeatherData input = new WeatherData();
        input.setAirPreasure(10);
        input.setTemperature(25);
        input.setWindSpeed(13);
        return input;
    }
}
