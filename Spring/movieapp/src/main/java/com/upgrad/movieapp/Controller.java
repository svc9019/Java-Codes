package com.upgrad.movieapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value="/page1")
    public String page1(){
        return "This is the First Page";
    }

    @RequestMapping(value="/page2")
    public String page2(){
        return "This is Second Page";
    }

    @Value("${message}")
    String message;

    @GetMapping("/welcome")
    public String getMessage()
    {
        return "Hi "+message;
    }
}
