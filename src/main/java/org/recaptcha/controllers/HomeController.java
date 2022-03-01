package org.recaptcha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import static org.recaptcha.utils.iLog.logInfo;
import static org.springframework.http.HttpMethod.POST;

@Controller
@PropertySource("classpath:application.properties")
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${secret.key}")
    private String secretKey;

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String loginUserWithRecaptcha(@RequestParam("name") String name, @RequestParam("g-recaptcha-response") String response){
        logInfo("Got " + name);

        String url = "https://www.google.com/recaptcha/api/siteverify";
        String params = "?secret="+secretKey+"&response="+response;

        ReCaptchaResponse res = restTemplate.exchange(url+params, POST, null, ReCaptchaResponse.class).getBody();

        logInfo("getting data from " + url+params);

        assert res != null;
        if(res.isSuccess() && res.getScore() >= 0.5){
            logInfo("Response status: true");
            logInfo("rate:"+res.getScore());
            logInfo(res.getAction());
            logInfo(res.getChallange_ts());
            logInfo(res.getHostname());
            return "redirect:/user";
        } else {
            logInfo("Response status: false");
            logInfo("rate:"+res.getScore());
            logInfo(res.getAction());
            logInfo(res.getChallange_ts());
            logInfo(res.getHostname());
            return "redirect:/login";
        }
    }

    @GetMapping("/user")
    public String userPage(){
        return "user";
    }
}