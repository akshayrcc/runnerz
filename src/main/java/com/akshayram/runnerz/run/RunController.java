package com.akshayram.runnerz.run;

import com.akshayram.runnerz.RunnerzApplication;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/runs")
public class RunController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RunnerzApplication.class);

    private final RunService runService;

    RunController(RunService runService) {
        this.runService = runService;
        logger.info("RunService injected!");
    }

//    @GetMapping
    @RequestMapping( method = RequestMethod.GET)
    List<Run> getAllRuns() {
        logger.info("RunController.getAllRuns() called");
        return runService.getAllRuns();
    }

    @GetMapping("/{id}")
    ResponseEntity<Run> getRunById(@PathVariable int id) throws RunNotFoundException {
        logger.info("RunController.getRunById() called");
        Run r = runService.getRun(id);
        return ResponseEntity.ok(r);
    }

    //post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Run> addRun(@Valid @RequestBody Run run) {
        logger.info("RunController.addRun() called");
        runService.createRun(run);
        return ResponseEntity.status(HttpStatus.CREATED).body(run);
    }

    //put
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateRun(@Valid @RequestBody Run run, @PathVariable Integer id) {
        logger.info("RunController.updateRun() called");
        runService.updateRun(run, id);
    }

    //delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void deleteRun(@PathVariable Integer id) {
        logger.info("RunController.deleteRun() called");
        runService.deleteRun(id);
    }
}
