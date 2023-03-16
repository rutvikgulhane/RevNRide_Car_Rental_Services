package com.revnride.app.dto.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

 

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class JwtResponse implements Serializable {

    /**token*/
    private String token;
    /**type*/
    private String type = "Bearer";
    /**id*/
    private Long id;
    /**username*/
    private String username;
    /**email*/
    private String email;
    /**List Localization */
    private List<LocalizationResponse> localizations;
    /**List String */
    private List<String> roles;

   
    public JwtResponse(String token, Long id, String username, String email, List<LocalizationResponse> localizations, List<String> roles) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.username = username;
        this.email = email;
        this.localizations = localizations;
        this.roles = roles;
    }
}

