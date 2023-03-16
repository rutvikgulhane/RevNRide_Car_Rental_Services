package com.revnride.app.service;

import java.util.List;
import java.util.Optional;

import com.revnride.app.dto.request.UserRequest;
import com.revnride.app.dto.response.ReservationResponse;
import com.revnride.app.dto.response.UserResponse;
import com.revnride.app.entity.User;
import com.revnride.app.exception.WrongDataException;

 


public interface UserService {
    
    Optional<User> findByUsername(String username);

    
    List<ReservationResponse> getReservationUser(Long id) throws WrongDataException;

     
    void deleteUser(Long id) throws WrongDataException;

     
    void update(User user);

    
    void update(UserRequest userRequest,Long id) throws WrongDataException;

     
    UserResponse findByEmail(String email);

    
    UserResponse findById(Long id) throws WrongDataException;

     
    void save(UserRequest user) throws WrongDataException;

     
    List<UserResponse> findAll();

     
    UserResponse findByReservationsIdRent(Long id);

}
