package com.rohit.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControllerHandler
{
    @GetMapping
    public String HomeContollerHandler()
    {
        return "Hello Catergary";
    }
}
