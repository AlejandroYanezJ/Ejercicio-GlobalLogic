package globallogic.ejercicio.service.impl;

import globallogic.ejercicio.dto.*;
import globallogic.ejercicio.entity.PhoneEntity;
import globallogic.ejercicio.entity.UserEntity;
import globallogic.ejercicio.exception.TokenValidationException;
import globallogic.ejercicio.exception.UserRegisterException;
import globallogic.ejercicio.repository.PhoneRespository;
import globallogic.ejercicio.repository.UsersRepository;
import globallogic.ejercicio.service.TokenService;
import globallogic.ejercicio.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PhoneRespository phoneRespository;

    @Autowired
    TokenService tokenService;

    @Override
    public UserSignUpResponseDTO registerUser(UserSignUpRequestDTO user) throws Exception {
        UserEntity userExist = usersRepository.findByEmail(user.getEmail());
        if (!Objects.nonNull(userExist)){
            UserEntity entity = getDataGenerateUser(user);
            UserEntity insert = usersRepository.save(entity);
            List<PhoneEntity> phones = getPhonesEntityFromArray(user.getPhones(),insert.getId());
            phones.stream().forEach(phoneEntity -> {
                phoneRespository.save(phoneEntity);
            });
            log.info("usuario registrado en la db");
            UserSignUpResponseDTO response = new UserSignUpResponseDTO(user,
                    entity.getCreated(),
                    entity.getLastLogin(),
                    entity.getToken(),
                    entity.getIsActive());

            return response;
        }
        else{
            throw new UserRegisterException(409,"Usuario ya registrado previamente");
        }
    }

    public UserEntity getDataGenerateUser(UserSignUpRequestDTO user){

        String dateString = getActualDate();
        return new UserEntity(null,
                user.getName(),
                user.getEmail(),
                encryptPassword(user.getPassword()),
                dateString,
                dateString,
                tokenService.generateToken(user.getEmail(),
                        dateString),
                true);
    }
    public List<PhoneEntity> getPhonesEntityFromArray(ArrayList<PhoneDTO> phones, Long userId) {
        List<PhoneEntity> response = new ArrayList<>();
        if(Objects.nonNull(phones) && phones.size()>0){
             phones.stream().forEach(phone->{
                 response.add(PhoneEntity.builder()
                         .userId(userId)
                         .citycode(phone.getCitycode())
                         .contrycode(phone.getContrycode())
                         .number(phone.getNumber())
                         .build());
             });
        }
        return response;
    }

    public List<PhoneDTO> getPhonesFromEntity(List<PhoneEntity> phones){
        List<PhoneDTO> response = new ArrayList<>();
        if (Objects.nonNull(phones) && phones.size()>0){
            phones.stream().forEach(phoneEntity->{
                response.add(PhoneDTO.builder()
                        .contrycode(phoneEntity.getContrycode())
                        .citycode(phoneEntity.getCitycode())
                        .number(phoneEntity.getNumber())
                        .build());
            });
        }
        return response;
    }

    public String encryptPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        encoder.encode(password);
        return encoder.encode(password);
    }

    public UserLoginResponseDTO loginUser(UserLoginRequestDTO user,String token) throws UserRegisterException, TokenValidationException {

        UserEntity entity = usersRepository.findByToken(token);

        if (!Objects.nonNull(entity)) {
            throw new UserRegisterException(404, "Usuario no encontrado");
        }
        if (!entity.getIsActive()) {
            throw new UserRegisterException(409, "Usuario no se encuentra activo");
        }
        //Validacion por token
        tokenService.validateToken(entity.getEmail(), entity.getLastLogin(), entity.getToken());
        String date = getActualDate();
        UserEntity entityUpdate = getDataUpdateUser(entity);
        UserEntity result = usersRepository.save(entityUpdate);
        //UserEntity result = usersRepository.updateUser(entityUpdate.getEmail(),entityUpdate.getLastLogin(),entityUpdate.getToken());
        log.info("usuario actualizado");
        List<PhoneEntity> phoneResult = phoneRespository.findByUserId(entity.getId());
        List<PhoneDTO> phones = getPhonesFromEntity(phoneResult);


        return new UserLoginResponseDTO(entityUpdate.getId(),
                entityUpdate.getCreated(),
                entityUpdate.getLastLogin(),
                entityUpdate.getToken(),
                entityUpdate.getIsActive(),
                entityUpdate.getName(),
                entityUpdate.getEmail(),
                entityUpdate.getPassword(),
                phones);
    }

    @Override
    public UserEntity getDataUpdateUser(UserEntity entity) {
        String dateString = getActualDate();
        return new UserEntity(entity.getId(),
                entity.getName(),
                entity.getEmail(),
                encryptPassword(entity.getPassword()),
                entity.getCreated(),
                dateString,
                tokenService.generateToken(entity.getEmail(),
                        dateString),
                true);
    }

    public String getActualDate(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(date);
    }
}
