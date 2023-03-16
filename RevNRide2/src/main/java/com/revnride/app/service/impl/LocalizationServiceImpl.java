package com.revnride.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revnride.app.dto.request.LocalizationRequest;
import com.revnride.app.dto.response.LocalizationResponse;
import com.revnride.app.entity.Localization;
import com.revnride.app.exception.WrongDataException;
import com.revnride.app.mapper.Mapper;
import com.revnride.app.repository.LocalizationRepository;
import com.revnride.app.service.LocalizationService;

import lombok.extern.slf4j.Slf4j;

 

@Service
@Slf4j
@Transactional
public class LocalizationServiceImpl implements LocalizationService {

    /**localizationRepository*/
    private final LocalizationRepository localizationRepository;
    private final Mapper<Localization, LocalizationResponse, LocalizationRequest> localizationMapper;

    @Autowired
    /**Constructor*/
    public LocalizationServiceImpl(LocalizationRepository localizationRepository, Mapper<Localization, LocalizationResponse, LocalizationRequest> localizationMapper) {
        this.localizationRepository = localizationRepository;
        this.localizationMapper = localizationMapper;
    }

 
    @Override
    public LocalizationResponse findByIdLocalization(long id) throws WrongDataException {
        if (!localizationRepository.existsById(id)) {
            log.error("---- BAD ID LOCALIZATION ----");
            throw new WrongDataException("Bad id localization");
        } else {
            log.info("---- GET LOCALIZATION ID "+id+" ----");
            return localizationMapper.toDto(localizationRepository.findById(id).get());
        }
    }

   
    @Override
    public LocalizationResponse findByCity(String city) throws WrongDataException {
        if (!localizationRepository.existsByCity(city)) {
            log.error("---- BAD ID LOCALIZATION ----");
            throw new WrongDataException("Bad city localization");
        } else {
            log.info("---- GET LOCALIZATION NAME "+city+" ----");
            return localizationMapper.toDto(localizationRepository.findByCity(city).get());
        }
    }

  
    @Override
    public List<LocalizationResponse> findAll() {
        log.info("---- GET ALL LOCALIZATION ----");
        return localizationRepository.findAll().stream().map(localization -> localizationMapper.toDto(localization)).collect(Collectors.toList());
    }

 
    @Override
    public void save(LocalizationRequest localizationRequest) {
        log.info("---- SAVE LOCALIZATION ----");
        localizationRepository.save(localizationMapper.toEntity(localizationRequest));
    }
 
    @Override
    public void deleteByCity(String city) {
        log.info("---- DELETE LOCALIZATION NAME "+city+" ----");
        localizationRepository.deleteByCity(city);
    }
}
