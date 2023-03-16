package com.revnride.app.dto.response;

import lombok.*;

import java.io.Serializable;

 

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MessageResponse implements Serializable {
    /**message*/
    String message;
}
