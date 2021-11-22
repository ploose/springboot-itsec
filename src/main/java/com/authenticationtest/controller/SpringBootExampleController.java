package com.authenticationtest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootExampleController {

    @RequestMapping("/")
    public String SpringBootHello() {
        return "You just authenticated with spring boot basic authentication.";
    }
    @RequestMapping("/index")
    public String index()
    {
        return "Everyone can see this";
    }
}