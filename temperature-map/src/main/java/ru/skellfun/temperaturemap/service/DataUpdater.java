package ru.skellfun.temperaturemap.service;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.skellfun.temperaturemap.config.Config;
import ru.skellfun.temperaturemap.dto.ResponseDTO;
import ru.skellfun.temperaturemap.entity.CityTemperature;
import ru.skellfun.temperaturemap.repository.CityTemperatureRepository;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class DataUpdater {
    private final Config config;
    private final CityTemperatureRepository cityTemperatureRepository;

    public ResponseDTO getAverageTemperature(String from, String to){

        return new ResponseDTO();
    }

    @Scheduled(timeUnit = TimeUnit.MINUTES, fixedRate = 1)
    public String loadTemperatures() {
        StringBuffer exception = new StringBuffer();
        config.getCities().forEach(city -> {
            try{
                double temperature = getCityTemperature(city);
                saveData(city, temperature);
            } catch (Exception e) {
                exception.append(city + ": " +e.getMessage() + System.lineSeparator());
            }
        });
        return exception.toString();
    }
    private double getCityTemperature(String city) throws ParseException,IllegalArgumentException {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();
        String response = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + city + ",ru&units=metric&appid=" + config.getApiKey(), String.class);
        System.out.println(response);
        JSONParser parser = new JSONParser();
        JSONObject jsonResponse =(JSONObject) parser.parse(response);
        if(Integer.parseInt(jsonResponse.get("cod").toString()) != 200){
            throw new IllegalArgumentException();
        }
        JSONObject main = (JSONObject) jsonResponse.get("main");
        return Double.parseDouble(main.get("temp").toString());
    }

    private void saveData(String city, double temperature) {
        CityTemperature cityTemperature = new CityTemperature();
        cityTemperature.setCity(city);
        cityTemperature.setTemperature(temperature);
        cityTemperatureRepository.saveAndFlush(cityTemperature);
    }
}
