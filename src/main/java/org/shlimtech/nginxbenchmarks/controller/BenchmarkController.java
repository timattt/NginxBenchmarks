package org.shlimtech.nginxbenchmarks.controller;

import lombok.extern.java.Log;
import org.shlimtech.nginxbenchmarks.dto.NameDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

@RestController
@Log
public class BenchmarkController {

    private static final int RECORDS_COUNT = 10_000;

    @GetMapping("/date")
    public ResponseEntity<?> date() {
        log.info("Date request");
        LocalDate currentDate = LocalDate.now();

        List<Map<String, String>> result = new LinkedList<>();

        for (int i = 0; i < RECORDS_COUNT; i++) {
            result.add(Map.of(
                    "year", Integer.toString(currentDate.getYear()),
                    "month", Integer.toString(currentDate.getMonthValue()),
                    "day", Integer.toString(currentDate.getDayOfMonth())
            ));
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("/name")
    public ResponseEntity<?> name(@RequestBody NameDTO nameDTO) {
        log.info("Name request");
        List<Map<String, String>> result = new LinkedList<>();

        for (int i = 0; i < RECORDS_COUNT; i++) {
            result.add(Map.of("name", nameDTO.getName()));
        }

        return ResponseEntity.ok(result);
    }

}
