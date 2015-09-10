package org.droolsdemo.weatherforecast.rules;

import org.droolsdemo.MyDroolsEngine;
import org.droolsdemo.weatherforecast.WeatherData;

public class WeatherReportWithRules {

    private MyDroolsEngine engine;

    protected MyDroolsEngine getEngine() {
        if (engine == null) {
            engine = new MyDroolsEngine();
            engine.loadRules("weatherReport.drl");
        }
        return engine;
    }

    public boolean isSunnyWeather(WeatherData input) {
        WeatherDataRequest request = new WeatherDataRequest(input);
        getEngine().run(request);
        return request.isSunnyWeather;
    }
}
