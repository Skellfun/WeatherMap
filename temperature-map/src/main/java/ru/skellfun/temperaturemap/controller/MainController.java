package ru.skellfun.temperaturemap.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.skellfun.temperaturemap.service.DataUpdater;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final DataUpdater dataUpdater;

    public ResponseEntity<?> getTemperatures(@PathVariable(name = "from") String dateFrom, @PathVariable(name = "to") String dateTo) {


        return ResponseEntity.ok().build();
    }
}
