package com.revnride.app.service;

import java.util.List;

import com.revnride.app.dto.request.ReservationRequest;
import com.revnride.app.dto.response.ReservationResponse;
import com.revnride.app.entity.Reservation;
import com.revnride.app.exception.WrongDataException;
 

public interface ReservationService {
    
    ReservationResponse findByIdRent(Long id);
 
    void deleteByIdRent(Long id);

    
    List<ReservationResponse> getCurrentReservation(Long id) throws WrongDataException;


    
    Reservation save(ReservationRequest reservationRequest) throws WrongDataException;

     
    List<ReservationResponse> findAll();

    
    List<ReservationResponse> findByCarIdCar(int id);

     
    ReservationResponse findFirstByCarIdCarOrderByIdRentDesc(int id);
}
