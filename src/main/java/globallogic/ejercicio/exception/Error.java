package globallogic.ejercicio.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Error {
    private Timestamp timestamp;
    private int codigo;
    private String detail;
}
