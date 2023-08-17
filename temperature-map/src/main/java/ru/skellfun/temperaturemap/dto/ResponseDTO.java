package ru.skellfun.temperaturemap.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    String city;
    double averageTemperature;
}
