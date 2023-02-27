package com.revnride.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnride.app.entities.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	
}