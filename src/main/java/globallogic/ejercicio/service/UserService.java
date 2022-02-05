package globallogic.ejercicio.service;

import globallogic.ejercicio.dto.*;
import globallogic.ejercicio.entity.PhoneEntity;
import globallogic.ejercicio.entity.UserEntity;
import globallogic.ejercicio.exception.TokenValidationException;
import globallogic.ejercicio.exception.UserException;

import java.util.ArrayList;
import java.util.List;


public interface UserService {

    public UserSignUpResponseDTO registerUser(UserSignUpRequestDTO user) throws Exception;
    public List<PhoneEntity> getPhonesEntityFromArray(ArrayList<PhoneDTO> phones, Long userId);
    public UserEntity getDataGenerateUser(UserSignUpRequestDTO user);
    public String encryptPassword(String password);
    public Boolean validatePassword(String dbPassword,String password ) ;

        public UserLoginResponseDTO loginUser(UserLoginRequestDTO user, String token) throws UserException, TokenValidationException;
    public UserEntity getDataUpdateUser(UserEntity entity) ;

    }
