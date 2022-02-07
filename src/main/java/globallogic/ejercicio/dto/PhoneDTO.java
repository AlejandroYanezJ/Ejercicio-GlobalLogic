package globallogic.ejercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class PhoneDTO {

    private Long number;
    private int citycode;
    private String contrycode;
}
