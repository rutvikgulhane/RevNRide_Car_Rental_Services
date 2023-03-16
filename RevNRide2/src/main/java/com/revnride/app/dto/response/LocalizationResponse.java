package com.revnride.app.dto.response;

import lombok.*;

import java.io.Serializable;

 

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class LocalizationResponse implements Serializable{

    private Long id;
    private String city;
}
