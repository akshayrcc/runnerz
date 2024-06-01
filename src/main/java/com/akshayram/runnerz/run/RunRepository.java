package com.akshayram.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {
    private final List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Morning Run", "COMPLETED", LocalDateTime.now(), 5, LocalDateTime.now().plusHours(1), Location.OUTDOOR));
        runs.add(new Run(2, "Evening Run", "COMPLETED", LocalDateTime.now(), 10, LocalDateTime.now().plus(2, java.time.temporal.ChronoUnit.HOURS), Location.INDOOR));
    }
}
