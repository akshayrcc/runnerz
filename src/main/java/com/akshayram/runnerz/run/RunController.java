package com.akshayram.runnerz.run;

import com.akshayram.runnerz.RunnerzApplication;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RunController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RunnerzApplication.class);

    private final RunRepository runRepository;

     RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
        logger.info("RunController created!");
    }

    @GetMapping("/run")
    List<Run> getAllRuns() {
        logger.info("RunController.getAllRuns() called");
        return runRepository.findAll();
    }
}
