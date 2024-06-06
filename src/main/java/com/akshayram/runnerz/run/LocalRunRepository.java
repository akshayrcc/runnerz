package com.akshayram.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LocalRunRepository {
    private final List<Run> runs = new ArrayList<>();

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Morning Run", "COMPLETED", LocalDateTime.now(), 5, LocalDateTime.now().plusHours(1), Location.OUTDOOR));
        runs.add(new Run(2, "Evening Run", "COMPLETED", LocalDateTime.now(), 10, LocalDateTime.now().plus(2, java.time.temporal.ChronoUnit.HOURS), Location.INDOOR));
    }

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(int id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    void add(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> runOptional = findById(id);
        runOptional.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    public void delete(Integer id) {
//        Optional<Run> runOptional = findById(id);
//        runOptional.ifPresent(runs::remove);
        runs.removeIf(r -> r.id().equals(id));
    }
}
