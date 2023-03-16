package com.revnride.app.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revnride.app.entity.Reservation;
import com.revnride.app.entity.User;

 


@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);

     
    Boolean existsByUsername(String username);

     
    Boolean existsByEmail(String email);

     
    Optional<User> findByEmail(String email);

   
    void deleteById(Long id);

    
    User findByReservations_Idrent(Long id);

    
    Boolean existsById(long id);

     
    Optional<User> findById(Long id);

    
    @Query("SELECT r FROM Reservation r WHERE r.user.id =:id")
    List<Reservation> getReservationUser(@Param("id") Long id);


}
