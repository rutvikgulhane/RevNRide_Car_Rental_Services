package com.revnride.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.dom4j.DocumentException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revnride.app.dto.request.ReservationRequest;
import com.revnride.app.dto.response.ReservationResponse;
import com.revnride.app.service.CarService;
import com.revnride.app.service.LocalizationService;
import com.revnride.app.service.ReservationService;
import com.revnride.app.service.UserService;


@RequestMapping(value = "/reservation")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {
    
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    
    private final ReservationService reservationServiceImpl;
    private final UserService userServiceImpl;
    private final CarService carServiceImpl;
    private final LocalizationService localizationServiceImpl;
    @Autowired
	public ReservationController(
			/* PdfResume pdfResume, */ ReservationService reservationServiceImpl, 
			UserService userServiceImpl, 
			CarService carServiceImpl, LocalizationService localizationServiceImpl/* , SendMailImpl sendMailImpl */) {
//        this.pdfResume = pdfResume;
        this.reservationServiceImpl = reservationServiceImpl;
        this.userServiceImpl = userServiceImpl;
        this.carServiceImpl = carServiceImpl;
        this.localizationServiceImpl = localizationServiceImpl;
//        this.sendMailImpl = sendMailImpl;
    }


    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/show")
    public ResponseEntity<List<ReservationResponse>> getReservations() {
        return new ResponseEntity<>(reservationServiceImpl.findAll(), HttpStatus.OK);
    }
    

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteReservation(@RequestParam Long id) {
        logger.info("------ The reservation was successfully deleted ------");
        reservationServiceImpl.deleteByIdRent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/get")
    public ResponseEntity<?> getReservation(@RequestParam Long id) {
        logger.info("------ Reservations displayed successfully ------");
        return new ResponseEntity<>(userServiceImpl.getReservationUser(id), HttpStatus.OK);
    }



    @ResponseBody
    @PostMapping(value = "/add")
    public ResponseEntity<?> addReservation(HttpServletResponse response, 
    		@Valid @RequestBody ReservationRequest reservationRequest) 
    				throws IOException, DocumentException {
        logger.info("------ Reservations added successfully ------" + reservationRequest);
        reservationServiceImpl.save(reservationRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/get-all-reservations-under-user")
    public ResponseEntity<?> getReservationById(@RequestParam Long id) {
        logger.info("------ Successfully displayed user bookings ------");
        return new ResponseEntity<>(reservationServiceImpl.getCurrentReservation(id), HttpStatus.OK);
    }
}
