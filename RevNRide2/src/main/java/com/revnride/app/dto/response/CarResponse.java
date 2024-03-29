package com.revnride.app.dto.response;

import lombok.*;

import java.io.Serializable;

 

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@ToString
public class CarResponse implements Serializable {

    /**idcar*/
    private int idcar;
    /**mark*/
    private String mark;
    /**model*/
    private String model;
    /**type*/
    private String type;
    /**yearProduction*/
    private int yearProduction;
    /**color*/
    private String color;
    /**engineCapacity*/
    private int engineCapacity;
    /**money*/
    private float money;
    /**image*/
    private String image;
    /**localization*/
    private LocalizationResponse localization;
}
