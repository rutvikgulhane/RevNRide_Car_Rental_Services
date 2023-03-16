package com.revnride.app.controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@RequestMapping(value = "/admin")
@RestController
@CrossOrigin
@Configuration
@EnableSwagger2
public class AdminController {
     
    @GetMapping(value = "/test")
    public String getString() {
        return "hello";
    }

    
    @GetMapping(value = "/about")
    public String getAbout() {
        return "about company";
    }

}
