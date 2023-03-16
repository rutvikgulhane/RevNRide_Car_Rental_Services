package com.revnride.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revnride.app.dto.request.UserRequest;
import com.revnride.app.dto.response.UserResponse;
import com.revnride.app.exception.WrongDataException;
import com.revnride.app.service.UserService;

 


@RequestMapping(value = "/user")
@RestController
@CrossOrigin
public class UserController {

   
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
     
    private final UserService userService;

   
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

      
    @PutMapping("/edit")
    public ResponseEntity<?> editUser(@RequestParam Long id, @Valid @RequestBody UserRequest userRequest) {
        logger.info("------ User edited successfully ------");
        userService.update(userRequest, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

  
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        logger.info("------ User deleted successfully ------");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<UserResponse> getUser(@RequestParam Long id) {
        logger.info("------ User get successfully ------");
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
}
