package com.revnride.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revnride.app.entity.Reservation;

 

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
 
    Optional<Reservation> findByIdrent(Long id);

    
    boolean existsByCar_Idcar(int id);

    
    boolean existsByIdrent(Long id);

    @Query("SELECT r FROM Reservation r WHERE r.user.id =:id and r.dataTo >= CURRENT_TIMESTAMP ")
    List<Reservation> findCurrent(@Param("id") Long id);
    
    int deleteByIdrent(Long id);

    
    List<Reservation> findByCar_Idcar(int id);

    
    Optional<Reservation> findFirstByCarIdcarOrderByIdrentDesc(int id);

}
