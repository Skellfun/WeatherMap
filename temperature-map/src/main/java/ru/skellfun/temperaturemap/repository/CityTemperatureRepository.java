package ru.skellfun.temperaturemap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skellfun.temperaturemap.entity.CityTemperature;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

public interface CityTemperatureRepository extends JpaRepository<CityTemperature, Long> {

    List<CityTemperature> findByDateTimeGreaterThanAndDateTimeLessThan(ZonedDateTime from, ZonedDateTime to);
}
