package com.revnride.app.dto.response;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString

public class UserResponse implements Serializable {

    private Long id;

    private String username;

    private String email;


    private String role;
}
