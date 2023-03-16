package com.revnride.app.dto.response;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

 
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CarReservationResponse implements Serializable {
    /**mark*/
    private String mark;
    /**model*/
    private String model;
    /**localizationStart*/
    private String localizationStart;
    /**localizationEnd*/
    private String localizationEnd;
    /**dateFrom*/
    private Date dateFrom;
    /**dateTo*/
    private Date dateTo;
    /**price*/
    private float price;
}
