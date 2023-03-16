package com.revnride.app.dto.request;

import lombok.*;

import java.io.Serializable;

 

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class RoleRequest implements Serializable {
    /**
     * name role
     */
    private String name;

}
