package com.revnride.app.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

 
 

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EditUser implements Serializable {

    /**id*/
    private long id;
    @Size(min = 3)
    /**username*/
    private String username;

    @Email
    /**email*/
    private String email;
    /**Set String*/
    private Set<String> role;

    /***/
    @Size(min = 6, max = 40)
    //walidacja hasla
    //@Pattern(regexp="^[A-Za-z0-9]")
    /**password*/
    private String password;


}
