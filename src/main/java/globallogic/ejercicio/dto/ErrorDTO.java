package globallogic.ejercicio.dto;

import globallogic.ejercicio.exception.Error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorDTO {
    List<Error> error;

}
