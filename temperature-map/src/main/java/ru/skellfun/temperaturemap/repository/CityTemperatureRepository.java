package ru.skellfun.temperaturemap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skellfun.temperaturemap.entity.CityTemperature;

public interface CityTemperatureRepository extends JpaRepository<CityTemperature, Long> {
}
