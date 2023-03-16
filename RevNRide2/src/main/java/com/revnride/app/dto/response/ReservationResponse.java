package com.revnride.app.dto.response;

import lombok.*;

import java.io.Serializable;

 
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class ReservationResponse implements Serializable{
    /**id rent*/
    private Long idRent;
    /**car response*/
    private CarResponse carResponse;
    /** dato to reservation*/
    private String dateTo;
    /** data from reservation*/
    private String dateFrom;
    /**localization end*/
    private LocalizationResponse localizationEnd;
    /**localization start*/
    private LocalizationResponse localizationStart;
    private float price;
}
