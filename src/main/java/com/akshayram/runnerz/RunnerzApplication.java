package com.akshayram.runnerz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RunnerzApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RunnerzApplication.class, args);

//        var welcomeMessage = new WelcomeMessage();
//        System.out.println(welcomeMessage.getWelcomeMessage());

        var welcomeMessage = context.getBean(WelcomeMessage.class);
        System.out.println(welcomeMessage);
        System.out.println(welcomeMessage.getWelcomeMessage());
        context.close();

    }
}
