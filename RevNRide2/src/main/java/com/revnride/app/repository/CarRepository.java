package com.revnride.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnride.app.entity.Car;

// Interface repository car to available connect on table database.

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    
    Optional<Car> findByIdcar(int id);

   
    boolean existsByIdcar(int id);

   
    Integer deleteByIdcar(int id);

    
    List<Car> findByLocalizationId(Long id);

    
    List<Car> findByLocalizationCity(String city);
}
