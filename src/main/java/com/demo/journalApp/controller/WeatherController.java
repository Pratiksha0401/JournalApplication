package com.demo.journalApp.controller;

import com.demo.journalApp.entity.ConfigJournalAppEntity;
import com.demo.journalApp.response.WeatherResponse;
import com.demo.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        String greeting = "";
        if (weatherResponse != null) {
            greeting = ", Weather feels like " + weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi " + authentication.getName() + greeting, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addGreeting(@RequestBody ConfigJournalAppEntity  entity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        weatherService.addConfig(entity);
        return new ResponseEntity<>("Hi " + authentication.getName(), HttpStatus.OK);
    }
}
