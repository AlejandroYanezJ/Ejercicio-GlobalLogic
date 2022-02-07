package globallogic.ejercicio.dto;

import globallogic.ejercicio.exception.Error;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorDTO {
    List<Error> error;

}
