package com.revnride.app.service;



import java.util.List;

import com.revnride.app.dto.request.CarRequest;
import com.revnride.app.dto.response.CarResponse;
import com.revnride.app.entity.Car;
import com.revnride.app.exception.WrongDataException;

 

public interface CarService {
    
    List<CarResponse> findAll();

   
    void save(CarRequest car) throws WrongDataException;

 
    CarResponse findByIdCar(int id) throws WrongDataException;
 
    Car update(int id,CarRequest carResponse) throws WrongDataException;

 
    void deleteCar(int id) throws WrongDataException;

     Integer deleteByIdCar(int id) throws WrongDataException;

    
    List<CarResponse> findByLocalizationId(Long id);

   
    List<CarResponse> findByLocalizationCity(String city);

}
