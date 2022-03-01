package org.recaptcha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("org.recaptcha")
@PropertySource("classpath:application.properties")
public class Config implements WebMvcConfigurer {

    @Value("${meta.charset}")
    private String defaultCharset;

    @Value("${front.prefix}")
    private String prefix;

    @Value("${front.suffix}")
    private String suffix;

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath(prefix);
        configurer.setDefaultEncoding(defaultCharset);

        Properties properties = new Properties();
        properties.setProperty("default_encoding", defaultCharset);
        configurer.setFreemarkerSettings(properties);
        return configurer;
    }

    @Bean
    public ViewResolver viewResolver(){
        FreeMarkerViewResolver view = new FreeMarkerViewResolver();
        view.setSuffix(suffix);
        view.setContentType("text/html;charset="+defaultCharset);
        view.setCache(false);
        return view;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
