package com.revnride.app.mapper;

import org.mapstruct.Mapper;

import com.revnride.app.dto.request.CarRequest;
import com.revnride.app.dto.response.CarResponse;
import com.revnride.app.entities.Car;

@Mapper
public interface CarMapper {

	CarResponse toDto(Car car);
	Car toEntity(CarRequest carRequest);
	
}
