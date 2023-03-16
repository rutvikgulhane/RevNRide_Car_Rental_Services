package com.revnride.app.mapper.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.revnride.app.dto.request.ReservationRequest;
import com.revnride.app.dto.response.CarResponse;
import com.revnride.app.dto.response.LocalizationResponse;
import com.revnride.app.dto.response.ReservationResponse;
import com.revnride.app.entity.Reservation;
import com.revnride.app.mapper.Mapper;

 

@Component
public class ReservationMapper implements Mapper<Reservation, ReservationResponse, ReservationRequest> {

   
    @Override
    public ReservationResponse toDto(Reservation reservation) {
        return new ReservationResponse().builder()
                .idRent(reservation.getIdrent())
                .carResponse(new CarResponse().builder()
                        .idcar(reservation.getCar().getIdcar())
                        .mark(reservation.getCar().getMark())
                        .model(reservation.getCar().getModel())
                        .type(reservation.getCar().getType().toString())
                        .yearProduction(reservation.getCar().getYearProduction())
                        .color(reservation.getCar().getColor())
                        .engineCapacity(reservation.getCar().getEngineCapacity())
                        .money(reservation.getCar().getMoney())
                        .image(reservation.getCar().getImage())
                        .localization(new LocalizationResponse().builder()
                                .id(reservation.getCar().getLocalization().getId())
                                .city(reservation.getCar().getLocalization().getCity()).build()
                        ).build())
                .dateTo(reservation.getDataTo().toString())
                .dateFrom(reservation.getDataFrom().toString())
                .localizationEnd(new LocalizationResponse().builder()
                        .id(reservation.getLocalizationEnd().getId())
                        .city(reservation.getLocalizationEnd().getCity())
                        .build())
                .localizationStart(new LocalizationResponse().builder()
                        .id(reservation.getLocalizationStart().getId())
                        .city(reservation.getLocalizationStart().getCity())
                        .build())
                .price(reservation.getPrice())
                .build();
    }

 
    @Override
    public Reservation toEntity(ReservationRequest reservationRequest) {
        return new Reservation().builder()
                .dataFrom(new Date(reservationRequest.getDateFrom()))
                .dataTo(new Date(reservationRequest.getDateTo()))
                .build();
    }

   
    @Override
    public Reservation update(Reservation reservation, ReservationRequest reservationRequest) {
        return null;
    }
}
