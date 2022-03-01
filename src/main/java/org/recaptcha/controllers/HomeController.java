package org.recaptcha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@PropertySource("classpath:application.properties")
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

}
