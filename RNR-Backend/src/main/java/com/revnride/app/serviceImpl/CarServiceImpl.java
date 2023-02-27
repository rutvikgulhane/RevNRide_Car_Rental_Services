package com.revnride.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.revnride.app.dto.request.CarRequest;
import com.revnride.app.dto.response.CarResponse;
import com.revnride.app.entities.Car;
import com.revnride.app.entities.Localization;
import com.revnride.app.entities.Reservation;
import com.revnride.app.exception.WrongDataException;
import com.revnride.app.mapper.CarMapper;
import com.revnride.app.repository.CarRepository;
import com.revnride.app.repository.DaoUserRepository;
import com.revnride.app.service.CarService;

public class CarServiceImpl implements CarService {

	@Autowired
	private CarMapper _carMapper;
	
	@Autowired
	private CarRepository _carRepository;
	
	@Autowired
	private DaoUserRepository _daoUserRepository;
	
	@Autowired
	private Reservation _reservation;
	
	@Autowired
	private Localization _localization;
	
	@Override
	public List<CarResponse> findAll() {
		// TODO Auto-generated method stub
		return _carRepository.findAll().stream().map(car -> _carMapper.toDto(car)).collect(Collectors.toList());
	}

	@Override
	public void save(CarRequest car) throws WrongDataException {
		

	}

	@Override
	public CarResponse findByIdCar(int id) throws WrongDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car update(int id, CarRequest carResponse) throws WrongDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCar(int id) throws WrongDataException {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer deleteByIdCar(int id) throws WrongDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarResponse> findByLocalizationId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarResponse> findByLocalizationCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
