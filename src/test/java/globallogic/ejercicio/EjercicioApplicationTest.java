package globallogic.ejercicio;

import globallogic.ejercicio.dto.UserSignUpRequestDTO;
import globallogic.ejercicio.dto.UserSignUpResponseDTO;
import globallogic.ejercicio.entity.UserEntity;
import globallogic.ejercicio.exception.UserException;
import globallogic.ejercicio.repository.PhoneRespository;
import globallogic.ejercicio.repository.UsersRepository;
import globallogic.ejercicio.service.TokenService;
import globallogic.ejercicio.service.impl.TokenServiceImpl;
import globallogic.ejercicio.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EjercicioApplicationTest {

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @InjectMocks
    TokenServiceImpl tokenServiceImpl;

    @Mock
    UsersRepository usersRepository;

    @Mock
    TokenService tokenService;

    @Mock
    PhoneRespository phoneRespository;

    private final String validToken = "eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAyMi8wMi8wNSAwMzo1NzozMiIsInN1YiI6ImVtYWlsQHBydWViYS5jb20ifQ.Pkvx7Thu5rp41Ir-0wsfOpVZz5pvvac4LwM9GXs6tLg";
    private final String invalidToken = "asdasdciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAyMi8wMi8wNSAwMzo1NzozMiIsInN1YiI6ImVtYWlsQHBydWViYS5jb20ifQ.Pkvx7Thu5rp41Ir-0wsfOpVZz5pvvac4LwM9GXs6tLg";
    private final String email = "email@prueba.com";
    private final String date = "2022/02/05 03:57:32";
    private final String validPassword = "a2asfGfdfdf4";
    private final String invalidPassword = "a2asfGfdfdf4@";
    private final String name = "Usuario Dummy";
    private final String uuid ="f049a818-9f97-4988-bcc5-ab5578627f1d";
    private final Long id = 1L;

    @Test
    void trueEncryptPasswordTest(){
        String encryptPassword = userServiceImpl.encryptPassword(validPassword);
        Boolean isValidPassword = userServiceImpl.validatePassword(encryptPassword,validPassword);
        Assertions.assertEquals(true,isValidPassword);
    }
    @Test
    void falseEncryptPasswordTest(){
        String encryptPassword = userServiceImpl.encryptPassword(validPassword);
        Boolean isValidPassword = userServiceImpl.validatePassword(encryptPassword,invalidPassword);
        Assertions.assertEquals(false,isValidPassword);
    }

    @Test
    void generateTokenTest(){
        String generatedToken = tokenServiceImpl.generateToken(email,date);
        Assertions.assertEquals(validToken,generatedToken);
    }

    @Test
    void trueValidateTokenTest() {
        Boolean isValidToken = tokenServiceImpl.validateToken(email,date,"Bearer "+validToken,validToken);
        Assertions.assertEquals(true,isValidToken);
    }
    @Test
    void falseValidateTokenTest() {
        Boolean isValidToken = tokenServiceImpl.validateToken(email,date,"Bearer "+invalidToken,validToken);
        Assertions.assertEquals(false,isValidToken);
    }

    @Test
    void getDataUpdateUserTest(){
        UserEntity dummyUser = new UserEntity(id,uuid,name,email,validPassword,date,date,validToken,true);
        when(usersRepository.findByEmail(any())).thenReturn(dummyUser);
        when(tokenService.generateToken(any(),any())).thenReturn(validToken);
        UserEntity dummyEntity = new UserEntity(id,uuid,name,email,validPassword,date,date,validToken,true);
        BDDMockito.given(usersRepository.findByEmail(any())).willReturn(dummyEntity);

        UserEntity dataUser = usersRepository.findByEmail(email);
        UserEntity result = userServiceImpl.getDataUpdateUser(dataUser);
        Assertions.assertTrue(result instanceof UserEntity);
    }

    @Test
    void getDataGenerateUserTest(){
        UserSignUpRequestDTO dummyUser = new UserSignUpRequestDTO(name,email,validPassword,null);
        UserEntity result = userServiceImpl.getDataGenerateUser(dummyUser);
        Assertions.assertTrue(result instanceof UserEntity);
    }

    @Test
    void successRegisterUserTest() throws Exception {
        UserSignUpRequestDTO dummyUser = new UserSignUpRequestDTO(name,email,validPassword,null);
        UserEntity dummyEntity = new UserEntity(id,uuid,name,email,validPassword,date,date,validToken,true);
        when(usersRepository.save(any())).thenReturn(dummyEntity);
        UserSignUpResponseDTO result = userServiceImpl.registerUser(dummyUser);
        Assertions.assertTrue(result instanceof UserSignUpResponseDTO);
    }
    @Test()
    void errorRegisterUserTest(){
        UserSignUpRequestDTO dummyUser = new UserSignUpRequestDTO(name,email,validPassword,null);
        UserEntity dummyEntity = new UserEntity(id,uuid,name,email,validPassword,date,date,validToken,true);
        BDDMockito.given(usersRepository.findByEmail(any())).willReturn(dummyEntity);
        Assertions.assertThrows(UserException.class,()->{
            userServiceImpl.registerUser(dummyUser);
        });
    }

}
