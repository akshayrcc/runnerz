package com.akshayram.runnerz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/list")
public class ExportController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/beans")
    @ResponseStatus(value = HttpStatus.OK)
    String[] registeredBeans() {
        return printBeans();
    }

    private String[] printBeans() {
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        if (autowireCapableBeanFactory instanceof SingletonBeanRegistry) {
            //            for (String singleton : singletonNames) {
//                System.out.println(singleton);
//            }
            return ((SingletonBeanRegistry) autowireCapableBeanFactory).getSingletonNames();
        }
        return null;
    }

}