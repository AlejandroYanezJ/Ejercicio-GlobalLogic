package globallogic.ejercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

private String name;
    @NotBlank(message = "El email no puede ser vacío")
    @Pattern(regexp="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",message="El formato de email es incorrecto. Ej: nombre@dominio.com")
    private String email;

    @NotBlank( message = "La contraseña no puede ser vacía")
    //@Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="La contraseña debe contener solo una letra mayuscula y 2 numeros. Ej: a2asfGfdfdf4")
    @Size(min =8 ,max =12 ,message = "El largo de la contraseña debe ser entre 8 y 12 caracteres")
    //Largo maximo 12 y minimo 8
    private String password;

    private ArrayList<PhoneDTO> phones;



}
