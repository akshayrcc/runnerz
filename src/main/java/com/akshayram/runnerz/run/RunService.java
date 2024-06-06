package com.akshayram.runnerz.run;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RunService {

    private final LocalRunRepository runRepository;

    public RunService(LocalRunRepository runRepository) {
        this.runRepository = runRepository;
    }

    public List<Run> getAllRuns() {
        return runRepository.findAll();
    }

    public Run getRun(Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException("Run with id " + id + " not found");
        }
        return run.get();
    }

    public Run createRun(Run run) {
        runRepository.add(run);
        return run;
    }

    public void updateRun(Run run, Integer id) {
        runRepository.update(run, id);
    }

    public void deleteRun(Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException("Run with id " + id + " not found");
        }
        runRepository.delete(id);
    }
}