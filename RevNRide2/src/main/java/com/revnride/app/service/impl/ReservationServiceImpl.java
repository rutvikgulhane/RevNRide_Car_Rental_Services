package com.revnride.app.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revnride.app.dto.request.ReservationRequest;
import com.revnride.app.dto.response.ReservationResponse;
import com.revnride.app.entity.Car;
import com.revnride.app.entity.Reservation;
import com.revnride.app.entity.User;
import com.revnride.app.exception.WrongDataException;
import com.revnride.app.mapper.Mapper;
import com.revnride.app.repository.CarRepository;
import com.revnride.app.repository.LocalizationRepository;
import com.revnride.app.repository.ReservationRepository;
import com.revnride.app.repository.UserRepository;
import com.revnride.app.service.ReservationService;
import com.revnride.app.service.EmailSending;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@Transactional
public class ReservationServiceImpl implements ReservationService {

  
    private final ReservationRepository reservationRepository;

    private final UserRepository userRepository;
  
    private final CarRepository carRepository;

    private final LocalizationRepository localizationRepository;
  
    private final EmailSendingImpl emailSendingImpl;
 
    private final Mapper<Reservation, ReservationResponse, ReservationRequest> reservationMapper;
    
    
    /**
    * sendMail mail sender
    */
    private final EmailSending emailSending;

   
    @Autowired
    /**Constructor*/
    public ReservationServiceImpl(ReservationRepository reservationRepository, UserRepository userRepository, 
    		CarRepository carRepository, LocalizationRepository localizationRepository, EmailSendingImpl emailSendingImpl, 
			Mapper<Reservation, ReservationResponse, ReservationRequest> reservationMapper, EmailSending emailSending) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.localizationRepository = localizationRepository;
        this.emailSendingImpl = emailSendingImpl;
        this.reservationMapper = reservationMapper;
        this.emailSending = emailSending;
    }

  
    @Override
    public ReservationResponse findByIdRent(Long id) {
        log.info("---- FIND RENT ID "+id+" ----");
        return reservationMapper.toDto(reservationRepository.findByIdrent(id).get());
    }



    @Override
    public void deleteByIdRent(Long id) {
        log.info("---- DELETE RENT ID "+id+" ----");
        reservationRepository.deleteByIdrent(id);
    }


    @Override
    public List<ReservationResponse> getCurrentReservation(Long id) throws WrongDataException {
        if (!userRepository.existsById(id)) {
            log.error("---- USER NOT EXIST ----");
            throw new WrongDataException("User not exist !!!");
        }
        log.info("---- FIND CURRENT RESERVATION UNDER USER ID "+id+" ----");
        return reservationRepository.findCurrent(id).stream().map(reservation -> reservationMapper.toDto(reservation)).collect(Collectors.toList());
    }


   

    @Override
    public Reservation save(ReservationRequest reservationRequest) throws WrongDataException {
    	
        if (!carRepository.existsByIdcar(reservationRequest.getIdCar())) {
            log.error("---- WRONG CAR ----");
            throw new WrongDataException("Wrong car!!!");
        }
        if (!userRepository.existsById(reservationRequest.getIdUser())) {
            log.error("---- USER NOT EXIST ----");
            throw new WrongDataException("User not exist!!!");
        }
        if (!localizationRepository.existsByCity(reservationRequest.getLocalizationStart())) {
            log.error("---- LOCALIZATION NOT EXIST ----");
            throw new WrongDataException("Localization start not exist!!!");
        }
        if (!localizationRepository.existsByCity(reservationRequest.getLocalizationEnd())) {
            log.error("---- LOCALIZATION NOT EXIST ----");
            throw new WrongDataException("Localization end not exist!!!");
        } else {
            User user = userRepository.findById(reservationRequest.getIdUser()).get();
            Car car = carRepository.findByIdcar(reservationRequest.getIdCar()).get();
            LocalDate dateBefore = LocalDate.parse(reservationRequest.getDateFrom(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate dateAfter = LocalDate.parse(reservationRequest.getDateTo(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
            Reservation reservations = new Reservation(carRepository.findByIdcar(reservationRequest.getIdCar()).get(), user, Date.valueOf(reservationRequest.getDateFrom()), Date.valueOf(reservationRequest.getDateTo()), localizationRepository.findByCity(reservationRequest.getLocalizationStart()).get(), localizationRepository.findByCity(reservationRequest.getLocalizationEnd()).get(), (noOfDaysBetween * car.getMoney()));
			car.setLocalization(localizationRepository.findByCity(reservationRequest.getLocalizationEnd())
					.get()); /* Change localization on end = reservation */
            carRepository.save(car);
            reservationRepository.save(reservations);
            user.setReservations(reservations);
            userRepository.save(user);
            log.info("---- SAVE RENT ID ----" + reservations);
            emailSending.sendEmail(user.getEmail(), "Thank you for order car:" + car.getMark() + " " + car.getModel() + " for " + noOfDaysBetween + " days in localization " + car.getLocalization().getCity() + " for prices: " + (noOfDaysBetween * car.getMoney()), "Car Reservation Successfull");
            return reservations;
        }

    }


    
    @Override
    public List<ReservationResponse> findAll() {
        log.info("---- FIND ALL RESERVATION ----");
        return reservationRepository.findAll().stream().map(reservation -> reservationMapper.toDto(reservation)).collect(Collectors.toList());
    }


  
    @Override
    public List<ReservationResponse> findByCarIdCar(int id) {
        log.info("---- FIND RESERVATION ON ID CAR ----");
        return reservationRepository.findByCar_Idcar(id).stream()
        		.map(reservation -> reservationMapper.toDto(reservation)).collect(Collectors.toList());
    }

 
    @Override
    public ReservationResponse findFirstByCarIdCarOrderByIdRentDesc(int id) {
        log.info("---- FIND LAST RESERVATION ON CAR ----");
        return reservationMapper.toDto(reservationRepository.findFirstByCarIdcarOrderByIdrentDesc(id).get());
    }
}
