package globallogic.ejercicio.dto;

import lombok.*;

@Getter
@Setter
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
