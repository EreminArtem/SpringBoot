package ru.eremin.springboot.lessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LessonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LessonsApplication.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/name={name}")
    public String greetings(@PathVariable("name") final String name) {
        return "Hello " + name;
    }
}



