package org.droolsdemo.weatherforecast.rules;


import org.droolsdemo.weatherforecast.WeatherData;
import org.droolsdemo.weatherforecast.WeatherReportTest;
import org.junit.Assert;
import org.junit.Test;

public class WeatherReportWithRulesTest {

    @Test
    public void testIsSunnyWeather() {

        WeatherReportWithRules cut = new WeatherReportWithRules();

        WeatherData input = new WeatherReportTest().getTestData();

        Assert.assertTrue(cut.isSunnyWeather(input));
    }

}
