package com.akshayram.runnerz.run;

import com.akshayram.runnerz.RunnerzApplication;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/runs")
public class RunController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RunnerzApplication.class);

    private final RunRepository runRepository;

    RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
        logger.info("RunController created!");
    }

    @GetMapping("/")
    List<Run> getAllRuns() {
        logger.info("RunController.getAllRuns() called");
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run getRunById(@PathVariable int id) throws RunNotFoundException {
        logger.info("RunController.getRunById() called");
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            //throw new RunNotFoundException("Run with id " + id + " not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run with id " + id + " not found");
        }
        return run.get();
    }

    //post
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    void addRun(@RequestBody Run run) {
        logger.info("RunController.addRun() called");
        runRepository.add(run);
    }

    //put
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateRun(@RequestBody Run run, @PathVariable Integer id) {
        logger.info("RunController.updateRun() called");
        runRepository.update(run, id);
    }

    //delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void deleteRun(@PathVariable int id) {
        logger.info("RunController.deleteRun() called");
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run with id " + id + " not found");
        }
        runRepository.delete(run.get().id());
    }
}
