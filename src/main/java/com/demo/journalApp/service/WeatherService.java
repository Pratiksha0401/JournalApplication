package com.demo.journalApp.service;

import com.demo.journalApp.Constants.Placeholders;
import com.demo.journalApp.cache.AppCache;
import com.demo.journalApp.entity.ConfigJournalAppEntity;
import com.demo.journalApp.repository.ConfigJournalAppRepository;
import com.demo.journalApp.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

//    @Value("${weather.api.key}")
//    private String apiKey;  // taking from db only

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    ConfigJournalAppRepository configJournalAppRepository;

    @Autowired
    RedisService redisService;

    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if (weatherResponse.getCurrent() != null) {
            return weatherResponse;
        } else {
            String finalAPI = appCache.APP_CACHE.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, AppCache.keys.WEATHER_API_KEY.toString());
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if (body != null) {
                redisService.set("weather_of_" + city, body, 300l);
            }
            return body;
        }
    }

    public boolean addConfig(ConfigJournalAppEntity configJournalAppEntity){
        ConfigJournalAppEntity save = configJournalAppRepository.save(configJournalAppEntity);
        return true;
    }
}

