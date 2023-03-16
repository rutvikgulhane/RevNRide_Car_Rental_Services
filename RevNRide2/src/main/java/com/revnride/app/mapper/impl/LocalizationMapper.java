package com.revnride.app.mapper.impl;

import org.springframework.stereotype.Component;

import com.revnride.app.dto.request.LocalizationRequest;
import com.revnride.app.dto.response.LocalizationResponse;
import com.revnride.app.entity.Localization;
import com.revnride.app.mapper.Mapper;

 

@Component
public class LocalizationMapper implements Mapper<Localization, LocalizationResponse, LocalizationRequest> {

   
    @Override
    public LocalizationResponse toDto(final Localization localization) {
        return new LocalizationResponse().builder()
                .id(localization.getId())
                .city(localization.getCity())
                .build();
    }
 
    @Override
    public Localization toEntity(final LocalizationRequest localizationRequest) {
        return new Localization().builder()
                .city(localizationRequest.getCity())
                .build();
    }

     
    @Override
    public Localization update(Localization localization, final LocalizationRequest localizationRequest) {
        localization.setCity(localization.getCity());
        return localization;
    }
}
