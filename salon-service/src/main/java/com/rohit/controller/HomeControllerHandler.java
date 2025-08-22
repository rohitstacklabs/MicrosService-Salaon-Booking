package com.rohit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControllerHandler {

    @GetMapping
    public  String HomeControllerHandler()
    {
        return "Salon microservice";
    }
}
