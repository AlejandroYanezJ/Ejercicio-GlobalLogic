package globallogic.ejercicio.service;

import globallogic.ejercicio.dto.PhoneDTO;
import globallogic.ejercicio.dto.UserDTO;
import globallogic.ejercicio.dto.UserResponseDTO;

import java.util.ArrayList;


public interface UserService {

    public UserResponseDTO registerUser(UserDTO user);
    public String getPhonesFromArray(ArrayList<PhoneDTO> phones);
    public String encryptPassword(String password);

    }
