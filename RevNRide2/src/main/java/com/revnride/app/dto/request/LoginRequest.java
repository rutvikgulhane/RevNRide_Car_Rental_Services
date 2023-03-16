package com.revnride.app.dto.request;

import lombok.*;

import java.io.Serializable;


 

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginRequest implements Serializable {

    /**serialVersionUID*/
    private static final long serialVersionUID = 5926468583005150707L;
    /**username*/
    private String username;
    /**password*/
    private String password;
}
