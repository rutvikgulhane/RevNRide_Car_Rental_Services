package com.revnride.app.mapper.impl;

import org.springframework.stereotype.Component;

import com.revnride.app.dto.request.CarRequest;
import com.revnride.app.dto.response.CarResponse;
import com.revnride.app.dto.response.LocalizationResponse;
import com.revnride.app.entity.Car;
import com.revnride.app.entity.enums.TypeCar;
import com.revnride.app.mapper.Mapper;

 


@Component
public class CarMapper implements Mapper<Car,CarResponse,CarRequest>{

   
    @Override
    public CarResponse toDto(final Car car) {
        return new CarResponse().builder()
                .idcar(car.getIdcar())
                .mark(car.getMark())
                .model(car.getModel())
                .type(car.getType().toString())
                .yearProduction(car.getYearProduction())
                .color(car.getColor())
                .engineCapacity(car.getEngineCapacity())
                .money(car.getMoney())
                .image(car.getImage())
                .localization(new LocalizationResponse().builder()
                        .id(car.getLocalization().getId())
                        .city(car.getLocalization().getCity()).build()
                ).build();
    }

 
    @Override
    public Car toEntity(final CarRequest carRequest) {
        return new Car().builder()
                .mark(carRequest.getMark())
                .model(carRequest.getModel())
                .type(TypeCar.valueOf(carRequest.getType()))
                .yearProduction(carRequest.getYearProduction())
                .color(carRequest.getColor())
                .engineCapacity(carRequest.getEngine())
                .money(carRequest.getMoney())
                .image(carRequest.getImage()).build();
    }

   
    @Override
    public Car update(Car car, final CarRequest carRequest) {
        car.setMark(carRequest.getMark());
        car.setModel(carRequest.getModel());
        car.setType(TypeCar.valueOf(carRequest.getType()));
        car.setYearProduction(carRequest.getYearProduction());
        car.setColor(carRequest.getColor());
        car.setEngineCapacity(carRequest.getEngine());
        car.setMoney(carRequest.getMoney());
        car.setImage(carRequest.getImage());
        return car;
    }
}
