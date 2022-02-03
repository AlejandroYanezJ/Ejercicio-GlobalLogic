package globallogic.ejercicio.service;

import globallogic.ejercicio.dto.UserDTO;
import globallogic.ejercicio.dto.UserResponseDTO;


public interface UserService {

    public Boolean userExist(UserDTO user);

    public UserResponseDTO registerUser(UserDTO user);

}
