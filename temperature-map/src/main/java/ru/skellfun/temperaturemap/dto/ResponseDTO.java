package ru.skellfun.temperaturemap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ResponseDTO {
    String city;
    double averageTemperature;
}
