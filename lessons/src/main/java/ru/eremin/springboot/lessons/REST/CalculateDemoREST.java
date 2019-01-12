package ru.eremin.springboot.lessons.REST;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor Eremin Artem on 12.01.2019.
 */

@RestController
public class CalculateDemoREST {

    @RequestMapping("/sum/a={a}&b={b}")
    public double sum(@PathVariable("a") final double a,
                      @PathVariable("b") final double b) {
        return a + b;
    }

    @RequestMapping("/div/a={a}&b={b}")
    public String div(@PathVariable("a") final double a,
                      @PathVariable("b") final double b) {
        if (b == 0) return "b = 0 :(";
        return String.valueOf(a / b);
    }
}
