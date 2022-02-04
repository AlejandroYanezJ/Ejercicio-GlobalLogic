package globallogic.ejercicio.service.impl;

import globallogic.ejercicio.dto.PhoneDTO;
import globallogic.ejercicio.dto.UserDTO;
import globallogic.ejercicio.dto.UserResponseDTO;
import globallogic.ejercicio.entity.UserEntity;
import globallogic.ejercicio.repository.UsersRepository;
import globallogic.ejercicio.service.TokenService;
import globallogic.ejercicio.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TokenService tokenService;

    @Override
    public UserResponseDTO registerUser(UserDTO user) {
        UserResponseDTO response = new UserResponseDTO();

        UserEntity userExist = usersRepository.findByEmail(user.getEmail());

        if (!Objects.nonNull(userExist)){
            UserEntity entity = generateUser(user);

            Object insert = usersRepository.save(entity);
            log.info("usuario registrado en la db");
        }
        else{
            //exception
        }

        return response;
    }

    public UserEntity generateUser(UserDTO user){
        UserEntity response = new UserEntity();

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String dateString = dtf.format(date);

        response.setToken(tokenService.generateToken(user.getEmail(), dateString));

        response.setEmail(user.getEmail());
        response.setName(user.getName());
        response.setPassword(encryptPassword(user.getPassword()));
        response.setPhones(getPhonesFromArray(user.getPhones()));
        response.setCreated(dateString);
        response.setLastLogin(dateString);
        response.setIsActive(true);
        return response;
    }
    public String getPhonesFromArray(ArrayList<PhoneDTO> phones) {
        String response = "";
        if(phones.size()>0){
            response = phones.stream()
                    .map((v-> v.getContrycode() + v.getCitycode() + v.getNumber()+";"))
                    .collect(Collectors.joining());
        }
        return response;
    }

    public String encryptPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        encoder.encode(password);
        return encoder.encode(password);
    }

    public String decryptPassword(String password){

        return "";
    }
}
