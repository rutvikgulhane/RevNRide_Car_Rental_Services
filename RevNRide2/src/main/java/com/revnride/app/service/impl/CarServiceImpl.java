package com.revnride.app.service.impl;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revnride.app.dto.request.CarRequest;
import com.revnride.app.dto.response.CarResponse;
import com.revnride.app.entity.Car;
import com.revnride.app.entity.Localization;
import com.revnride.app.exception.WrongDataException;
import com.revnride.app.mapper.Mapper;
import com.revnride.app.repository.CarRepository;
import com.revnride.app.repository.LocalizationRepository;
import com.revnride.app.repository.ReservationRepository;
import com.revnride.app.repository.UserRepository;
import com.revnride.app.service.CarService;

import lombok.extern.slf4j.Slf4j;

 
@Service
@Slf4j
@Transactional
public class CarServiceImpl implements CarService {

    /**carRepository*/
    private final CarRepository carRepository;
    /**reservationRepository*/
    private final ReservationRepository reservationRepository;
    /**localizationRepository*/
    private final LocalizationRepository localizationRepository;
    /**userRepository*/
    private final UserRepository  userRepository;
    /**CarMapper*/
    private final Mapper<Car,CarResponse,CarRequest> carMapper;

    @Autowired
    /**Constructor*/
    public CarServiceImpl(CarRepository carRepository, ReservationRepository reservationRepository, LocalizationRepository localizationRepository, UserRepository userRepository, Mapper<Car,CarResponse,CarRequest> carMapper) {
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
        this.localizationRepository = localizationRepository;
        this.userRepository = userRepository;
        this.carMapper = carMapper;
    }

    
    @Override
    public List<CarResponse> findAll() {
        log.info("---- GET ALL CAR ----");
        return carRepository.findAll().stream().map(car -> carMapper.toDto(car)).collect(Collectors.toList());
    }

   
    
    @Override
    public void save(CarRequest carRequest) throws WrongDataException {
        if (!localizationRepository.existsByCity(carRequest.getCity())) {
            log.error("---- WRONG LOCALIZATION ----");
            throw new WrongDataException("Wrong localization!!!");
        }
        Localization localization = localizationRepository.findByCity(carRequest.getCity()).get();
        Car car = carMapper.toEntity(carRequest);
        car.setLocalization(localization);
        carRepository.save(car);
        log.info("---- SAVE CAR ----");
    }

     
    @Override
    public CarResponse findByIdCar(int id) throws WrongDataException {
        if (carRepository.existsByIdcar(id)) {
            log.info("---- GET CAR ID "+id+" ----");
            return carMapper.toDto(carRepository.findByIdcar(id).get());
        } else {
            log.error("---- WRONG CAR ----");
            throw new WrongDataException("Wrong car");
        }

    }

  
    @Override
    public Car update(int id,CarRequest carRequest) throws WrongDataException {
        if (carRepository.existsByIdcar(id)) {
            Car car = carRepository.findByIdcar(id).get();
            car = carMapper.update(car,carRequest);
            car.setLocalization((localizationRepository.findByCity(carRequest.getCity()).get()));
            log.info("---- EDIT CAR ID "+id+" ----");
            return carRepository.save(car);
        } else {
            log.error("---- WRONG CAR ----");
            throw new WrongDataException("Wrong car!!!");
        }
    }

  
    @Override
    public void deleteCar(int id) throws WrongDataException {
        if (!carRepository.existsByIdcar(id)) {
            log.error("---- WRONG CAR ----");
            throw new WrongDataException("Wrong car");
        } else {
            carRepository.deleteByIdcar(id);
            log.info("---- DELETE CAR "+id+" ----");
        }
    }
 
    @Override
    public Integer deleteByIdCar(int id) {
        log.info("---- DELETE ID CAR "+id+" ----");
        return carRepository.deleteByIdcar(id);
    }

   
    @Override
    public List<CarResponse> findByLocalizationId(Long id) {
        log.info("---- FIND ALL CAR ON LOCALIZATION ID "+id+" ----");
        return carRepository.findByLocalizationId(id).stream().map(car -> carMapper.toDto(car)).collect(Collectors.toList());
    }

   
    @Override
    public List<CarResponse> findByLocalizationCity(String city){
        if (localizationRepository.existsByCity(city)) {
            log.info("---- FIND ALL CAR ON LOCALIZATION NAME "+city+" ----");
            return carRepository.findByLocalizationCity(city).stream().map(car -> carMapper.toDto(car)).collect(Collectors.toList());
        } else {
            log.error("---- WRONG CITY ----");
            throw new WrongDataException("Wrong city");
        }
    }

}
