package globallogic.ejercicio.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLoginResponseDTO {

    String id;
    String created;
    String lastLogin;
    String token;
    Boolean isActive;
    String name;
    String email;
    String password;
    List<PhoneDTO> phones;
}
