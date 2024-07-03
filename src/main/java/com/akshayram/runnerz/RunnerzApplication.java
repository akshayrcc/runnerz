package com.akshayram.runnerz;

import com.akshayram.runnerz.address.UserHttpClient;
import com.akshayram.runnerz.general.WelcomeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class RunnerzApplication {
    //logger added to the project
    private static final Logger logger = LoggerFactory.getLogger(RunnerzApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RunnerzApplication.class, args);
        logger.info("RunnerzApplication started successfully!");

        //some bean testing
        var welcomeMessage = context.getBean(WelcomeMessage.class);
        logger.info("Added bean is: " + welcomeMessage);
        logger.info(welcomeMessage.getWelcomeMessage());

//        logger.info("RunnerzApplication stopped!");
//        context.close();

    }

    @Bean
    UserHttpClient userHttpClient() {
        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
        return factory.createClient(UserHttpClient.class);
    }

//    @Bean
//    CommandLineRunner runner() {
//        return args -> {
//            logger.info("Command Line Runner!");
//            Run run = new Run(1, "Morning Run", "COMPLETED", LocalDateTime.now(), 5, LocalDateTime.now().plus(1, java.time.temporal.ChronoUnit.HOURS), Location.OUTDOOR);
//            logger.info("The run details:" + run);
//            ;
//        };
//    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//        };
//    }
}
