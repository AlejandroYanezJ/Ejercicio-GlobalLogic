package globallogic.ejercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSignUpResponseDTO {

     /*
    id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería
más deseable un UUID)
○ created: fecha de creación del usuario
○ lastLogin: del último ingreso
○ token: token de acceso de la API (debe utilizar JWT)
○ isActive: Indica si el usuario sigue habilitado dentro del sistema.

     */

    private UserSignUpRequestDTO user;
    private String created;
    private String lastLogin;
    private String token;
    private Boolean isActive;



}
