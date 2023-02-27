package com.revnride.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnride.app.entities.Car;
import com.revnride.app.entities.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
}