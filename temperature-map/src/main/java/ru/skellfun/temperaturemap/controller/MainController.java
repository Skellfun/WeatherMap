package ru.skellfun.temperaturemap.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skellfun.temperaturemap.dto.ResponseDTO;
import ru.skellfun.temperaturemap.service.DataUpdater;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final DataUpdater dataUpdater;

    @GetMapping("/average")
    public ResponseEntity<?> getTemperatures(@RequestParam(name = "from") String from, @RequestParam(name = "to") String to) {
        List<ResponseDTO> responseDTOList = dataUpdater.getAverageTemperatures(from, to);
        if(responseDTOList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(responseDTOList);
    }
}
