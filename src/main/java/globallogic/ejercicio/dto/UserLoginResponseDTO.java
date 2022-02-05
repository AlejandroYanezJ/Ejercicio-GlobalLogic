package globallogic.ejercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLoginResponseDTO {

    Long id;
    String created;
    String lastLogin;
    String token;
    Boolean isActive;
    String name;
    String email;
    String password;
    List<PhoneDTO> phones;
}
