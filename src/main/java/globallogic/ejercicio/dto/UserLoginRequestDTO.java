package globallogic.ejercicio.dto;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLoginRequestDTO {

    @NotEmpty(message = "El email no puede ser vacio")
    @NotBlank(message = "El email no puede estar en blanco")
    @Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",message="El formato de email es incorrecto. Ej: nombre@dominio.com")
    String email;

    @NotEmpty( message = "La contrasena no puede ser vacia")
    @NotBlank(message = "La contrasena no puede estar en blanco")
    @Size(min =8 ,max =12 ,message = "El largo de la contraseña debe ser entre 8 y 12 caracteres")
    String password;
}
