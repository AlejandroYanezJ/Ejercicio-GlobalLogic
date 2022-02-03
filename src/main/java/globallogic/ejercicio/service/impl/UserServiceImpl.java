package globallogic.ejercicio.service.impl;

import globallogic.ejercicio.dto.UserDTO;
import globallogic.ejercicio.dto.UserResponseDTO;
import globallogic.ejercicio.entity.UserEntity;
import globallogic.ejercicio.repository.UsersRepository;
import globallogic.ejercicio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;


    @Override
    public Boolean userExist(UserDTO user) {
        return usersRepository.findIdByEmail(user.getEmail());
    }

    @Override
    public UserResponseDTO registerUser(UserDTO user) {
        UserResponseDTO response = new UserResponseDTO();

        Boolean exist = userExist(user);

        if (!exist){
            UserEntity entity = new UserEntity();
            entity.setEmail(user.getEmail());
            entity.setName(user.getName());
            entity.setPassword(user.getPassword());
            //Agregar funcion que transforme numeros de telefono
            entity.setPhones(user.getPhones().toString());
            Object insert = usersRepository.save(entity);
        }
        else{
            //exception
        }

        return response;
    }
}
