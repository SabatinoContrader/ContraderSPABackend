package it.contrader.sprint4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class HelloController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String hello (Map<String, Object> model) {
        return "hello";
    }

}
