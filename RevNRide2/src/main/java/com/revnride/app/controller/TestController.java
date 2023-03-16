package com.revnride.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revnride.app.dto.response.MessageResponse;

 

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http//localhost:3000")
public class TestController {

    
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

   
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public MessageResponse userAccess() {
        return new MessageResponse("User Content.");
    }

    
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponse adminAccess() {
        return new MessageResponse("Admin Board.");
    }
}
