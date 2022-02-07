package globallogic.ejercicio.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class PhoneDTO {

    private Long number;
    private int citycode;
    private String contrycode;
}
