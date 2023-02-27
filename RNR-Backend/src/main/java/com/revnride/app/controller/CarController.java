package com.revnride.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revnride.app.dto.response.CarResponse;
import com.revnride.app.serviceImpl.CarServiceImpl;

@RequestMapping("/car")
@RestController
@CrossOrigin
public class CarController {

	 /**
     * Logger use to logger on server.
     */
	private static final Logger logger = LoggerFactory. getLogger(CarController.class);

	@Autowired
	private CarServiceImpl _carServiceImpl;
	
	@GetMapping("/cars")
	public ResponseEntity<List<CarResponse>> getAllCars(){
		return new ResponseEntity<>(_carServiceImpl.findAll(), HttpStatus.OK);
	}

}
