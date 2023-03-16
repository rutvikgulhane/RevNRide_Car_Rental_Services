package com.revnride.app.dto.request;

import lombok.*;

import java.io.Serializable;

 

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class LocalizationRequest implements Serializable {

    /**City*/
    private String city;

}
