package com.akshayram.runnerz;

import com.akshayram.runnerz.run.Location;
import com.akshayram.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class RunnerzApplication {
    //logger added to the project
    private static final Logger logger = LoggerFactory.getLogger(RunnerzApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RunnerzApplication.class, args);
        logger.info("RunnerzApplication started successfully!");

        //some bean testing
        var welcomeMessage = context.getBean(WelcomeMessage.class);
        System.out.println("Added bean is: " + welcomeMessage);
        System.out.println(welcomeMessage.getWelcomeMessage());


//        logger.info("RunnerzApplication stopped!");
//        context.close();

    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            logger.info("Command Line Runner!");
            Run run = new Run(1, "Morning Run", "COMPLETED", LocalDateTime.now(), 5, LocalDateTime.now().plus(1, java.time.temporal.ChronoUnit.HOURS), Location.OUTDOOR);
            logger.info("The run details:" + run);
            ;
        };
    }
}
