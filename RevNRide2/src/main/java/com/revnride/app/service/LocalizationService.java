package com.revnride.app.service;

import java.util.List;

import com.revnride.app.dto.request.LocalizationRequest;
import com.revnride.app.dto.response.LocalizationResponse;
import com.revnride.app.exception.WrongDataException;


 

public interface LocalizationService {
 
     
    LocalizationResponse findByIdLocalization(long id) throws WrongDataException;

    
    LocalizationResponse findByCity(String city) throws WrongDataException;

    
    List<LocalizationResponse> findAll();

   
    void save(LocalizationRequest localizationRequest);

   
    void deleteByCity(String city);
}
