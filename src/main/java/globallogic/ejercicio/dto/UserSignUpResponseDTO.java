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


    private UserSignUpRequestDTO user;
    private String created;
    private String lastLogin;
    private String token;
    private Boolean isActive;
    private String id;



}
