package globallogic.ejercicio.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserException extends Exception{
    int code;
    String message;
}
