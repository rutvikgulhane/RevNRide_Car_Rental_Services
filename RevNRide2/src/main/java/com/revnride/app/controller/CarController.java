package com.revnride.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revnride.app.dto.request.CarRequest;
import com.revnride.app.dto.response.CarResponse;
import com.revnride.app.exception.WrongDataException;
import com.revnride.app.service.CarService;
import com.revnride.app.service.LocalizationService;
import com.revnride.app.service.ReservationService;

 

@RequestMapping(value = "/car")
@RestController
@CrossOrigin
public class CarController {

//  Logger use to logger on server.   
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);
    
    private final CarService carServiceImpl;
    
    private final ReservationService reservationServiceImpl;
     
    private final LocalizationService localizationServiceImpl;

    
    @Autowired
    public CarController(CarService carServiceImpl, ReservationService reservationServiceImpl, LocalizationService localizationServiceImpl) {
        this.carServiceImpl = carServiceImpl;
        this.reservationServiceImpl = reservationServiceImpl;
        this.localizationServiceImpl = localizationServiceImpl;
    }


    @PostMapping("/add-car")
    public ResponseEntity<?> addCar(@Valid @RequestBody CarRequest carRequest) throws WrongDataException {
        logger.info("------ Car added successfully ------");
        carServiceImpl.save(carRequest);
        return new ResponseEntity<>(true, HttpStatus.OK);

    }


    @GetMapping(value = "/show-all-cars")
    public ResponseEntity<List<CarResponse>> showCarAll() {
        logger.info("---- GET ALL CAR ----");
        return new ResponseEntity<>(carServiceImpl.findAll(), HttpStatus.OK);
    }


    @ResponseBody
    @GetMapping(value = "/get-car-localization")
    public ResponseEntity<?> showCarLocalization(@RequestParam String city) {
        logger.info("------ Car locations displayed successfully ------");
        return new ResponseEntity<>(carServiceImpl.findByLocalizationCity(city), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete-car")
    public ResponseEntity<?> deleteCar(@RequestParam int id) {
        carServiceImpl.deleteCar(id);
        logger.info("------ The car was successfully deleted ------");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/get-car")
    public ResponseEntity<?> getCar(@RequestParam int id) throws WrongDataException {
        logger.info("------ Cars displayed successfully ------", id);
        return new ResponseEntity<>(carServiceImpl.findByIdCar(id), HttpStatus.OK);
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit-car")
    public ResponseEntity<?> editCar(@RequestParam int id, @RequestBody CarRequest carRequest) {
        logger.info("------ The car was successfully edited ------");
        carServiceImpl.update(id, carRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
