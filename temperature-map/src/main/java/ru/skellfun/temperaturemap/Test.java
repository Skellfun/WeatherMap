package ru.skellfun.temperaturemap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.skellfun.temperaturemap.config.Config;
import ru.skellfun.temperaturemap.service.DataUpdater;

@Component
public class Test implements CommandLineRunner {

    @Autowired
    private Config config;

    @Autowired
    private DataUpdater dataUpdater;

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(LocalDate.now());
//        System.out.println(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_INSTANT));
//        System.out.println(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime().truncatedTo(ChronoUnit.SECONDS));
//        System.out.println(dataUpdater.loadTemperatures());
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();
        String response = restTemplate.getForObject("https://api.hh.ru/areas/113", String.class);
        System.out.println(response);
    }
}
