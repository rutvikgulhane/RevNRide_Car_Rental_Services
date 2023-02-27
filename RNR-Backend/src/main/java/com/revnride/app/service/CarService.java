package com.revnride.app.service;

import java.util.List;

import com.revnride.app.dto.request.CarRequest;
import com.revnride.app.dto.response.CarResponse;
import com.revnride.app.entities.Car;
import com.revnride.app.exception.WrongDataException;

public interface CarService {

	 List<CarResponse> findAll();

	    /**
	     * Method to save new car.
	     * @param car new data car.
	     * @return return new added car.
	     * @throws WrongDataException when request has wrong localization.
	     */
	    void save(CarRequest car) throws WrongDataException;

	    /**
	     * Method find car on id
	     * @param id id on find car
	     * @return car on id.
	     * @throws WrongDataException when car not exist.
	     */
	    CarResponse findByIdCar(int id) throws WrongDataException;

	    /**
	     * Method to edit data car.
	     * @param id id car
	     * @param carResponse data new car.
	     * @return new data update car.
	     * @throws WrongDataException where id car not exist.
	     */
	    Car update(int id,CarRequest carResponse) throws WrongDataException;

	    /**
	     * Delete car on id.
	     * @param id id car to delete.
	     * @return return id deleting car.
	     * @throws WrongDataException when id car is wrong.
	     */
	    void deleteCar(int id) throws WrongDataException;

	    /**
	     * Delete car on id.
	     * @param id id car to delete.
	     * @return return id deleting car.
	     * @throws WrongDataException when id car not exist.
	     */
	    Integer deleteByIdCar(int id) throws WrongDataException;

	    /**
	     * Find car on localization.
	     * @param id id localization.
	     * @return return List car witch id localization.
	     */
	    List<CarResponse> findByLocalizationId(Long id);

	    /**
	     * Find car on localization on name city.
	     * @param city name city.
	     * @return return List car on localization city.
	     * @throws WrongDataException when city name not exist.
	     */
	    List<CarResponse> findByLocalizationCity(String city);
}
