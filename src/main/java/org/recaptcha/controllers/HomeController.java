package org.recaptcha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.POST;

public class HomeController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping()
    public String home(){
        return "home";
    }

}
