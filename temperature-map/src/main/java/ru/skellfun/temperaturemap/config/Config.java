package ru.skellfun.temperaturemap.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@Configuration
@ConfigurationProperties
@EnableScheduling
@Getter
@Setter
public class Config {
    @Value("${API_KEY}")
    private String apiKey;
    List<String> cities;
}
