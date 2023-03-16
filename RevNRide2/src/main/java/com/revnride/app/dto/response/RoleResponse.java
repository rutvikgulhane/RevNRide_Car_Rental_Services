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
public class RoleResponse implements Serializable {
    /**
     * id role
     */
    private Integer id;
    /**
     * role name
     */
    private String name;
}
