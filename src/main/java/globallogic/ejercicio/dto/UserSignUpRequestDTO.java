package globallogic.ejercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSignUpRequestDTO {

private String name;
    @NotEmpty(message = "El email no puede ser vacio")
    @NotBlank(message = "El email no puede estar en blanco")
    @Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",message="El formato de email es incorrecto. Ej: nombre@dominio.com")
    private String email;

    @NotEmpty( message = "La contrasena no puede ser vacia")
    @NotBlank(message = "La contrasena no puede estar en blanco")
    //Debe tener solo una Mayúscula y solamente dos números (no necesariamente
    //consecutivos), en combinación de letras minúsculas, largo máximo de 12 y mínimo 8.
    //@Pattern(regexp="^(.* ?=.[0-9]{2,2}) ( ?=.[A-Z]{1,1}) (?=.[a-z]{5,} ).*$",message="La contraseña debe contener solo una letra mayuscula y 2 numeros. Ej: a2asfGfdfdf4")
    @Size(min =8 ,max =12 ,message = "El largo de la contraseña debe ser entre 8 y 12 caracteres")
    //Largo maximo 12 y minimo 8
    private String password;

    private ArrayList<PhoneDTO> phones;



}
