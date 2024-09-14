package com.example.weather.controller;

import com.example.weather.parse.WeatherResponse;
import com.example.weather.service.WeatherClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {
    private final WeatherClient weatherClient;

    public WeatherController(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @GetMapping("/weather")
    public Mono<WeatherResponse> getWeather(@RequestParam String city) {
        String apiKey = "597fbc55f7bcbdbf89b6628a973882fb";
        return weatherClient.getWeather(city, apiKey);
    }
}
