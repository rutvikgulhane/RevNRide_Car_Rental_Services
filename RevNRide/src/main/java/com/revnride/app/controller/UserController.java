package com.revnride.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revnride.app.dto.response.UserResponse;
import com.revnride.app.service.UserService;

@RequestMapping("/user")
@RestController
@CrossOrigin
//UserController is use to supports operations about database table User.
public class UserController {
	
	/**
     * Logger use to logger on server.
     */
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUser(@RequestParam Long id) {
		logger.info("----------getting user details-------------");
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK); 
	}
	

}
