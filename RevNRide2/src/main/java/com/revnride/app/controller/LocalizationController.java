package com.revnride.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revnride.app.dto.request.LocalizationRequest;
import com.revnride.app.dto.response.LocalizationResponse;
import com.revnride.app.exception.WrongDataException;
import com.revnride.app.service.LocalizationService;


@RestController
@RequestMapping(value = "/city")
@CrossOrigin
public class LocalizationController {

   
    private static final Logger logger = LoggerFactory.getLogger(LocalizationController.class);
   
    @Autowired
    private LocalizationService localizationServiceImpl;

 
//    @Autowired
//    public LocalizationController(LocalizationService localizationServiceImpl) {
//        this.localizationServiceImpl = localizationServiceImpl;
//    }

    @ResponseBody
    @GetMapping(value = "/show-all-cities")
    public ResponseEntity<List<LocalizationResponse>> showAll() {
        return new ResponseEntity<>(localizationServiceImpl.findAll(), HttpStatus.OK);
    }


    @ResponseBody
    @GetMapping(value = "/show-city-by-id")
    public ResponseEntity<?> showLocalizationId(@RequestParam int id) {
        logger.info("------ Successfully returned location after id ------");
        return new ResponseEntity<>(localizationServiceImpl.findByIdLocalization(id), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/show-city-by-name")
    public ResponseEntity<?> showLocalizationCity(@RequestParam String city) {
        logger.info("------ Location by city name was returned successfully ------");
        return new ResponseEntity<>(localizationServiceImpl.findByCity(city), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addCity(@RequestBody LocalizationRequest localizationRequest) {
        localizationServiceImpl.save(localizationRequest);
        logger.info("------ City location added successfully ------");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
