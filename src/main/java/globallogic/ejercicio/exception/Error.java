package globallogic.ejercicio.exception;


import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Error {
    private Timestamp timestamp;
    private int codigo;
    private String detail;
}
