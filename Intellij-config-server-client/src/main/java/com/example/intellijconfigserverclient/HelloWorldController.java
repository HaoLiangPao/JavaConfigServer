package com.example.intellijconfigserverclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloWorldController {

    // Default value for certain configurations
    @Value("${my.greeting}")
    private String greetingMessage;

    // Default value for certain configurations
    @Value("${my.greetingDefault: default value}")
    private String greetingMessageDefault;

    // Default value for certain configurations
    @Value("${my.list.values}")
    private List<String> listConfig;

    // Hash -> to get an object as a map
    @Value("#{${dbValues}}")
    private Map<String, String> dbValues;

    // Get configuration through Bean
    @Autowired
    private dbSettings dbSettings;

    @RequestMapping
    public String helloWorld() {
        return "Hello World from Spring Boot";
    }

    @RequestMapping("/goodbye")
    public String goodBye() {
        return "Good Bye from Spring Boot";
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Greeting Message: " + greetingMessage + "\n" + "Greeting Default: " + greetingMessageDefault + "\n" +
                "List Config: " + listConfig + "\n" + "dbValues Map: " + dbValues + "\n" + "dbBean: " +
                dbSettings.getConnection() + "\n" + dbSettings.getHost() + "\n";
    }
}
