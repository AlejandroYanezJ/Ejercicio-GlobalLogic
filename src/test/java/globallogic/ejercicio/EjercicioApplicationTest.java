package globallogic.ejercicio;

import globallogic.ejercicio.service.TokenService;
import globallogic.ejercicio.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EjercicioApplicationTest {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Test
    void getDataGenerateUserTest(){

    }

    @Test
    void encryptPasswordTest(){
        String password ="a2asfGfdfdf4";
        String encryptPassword = userService.encryptPassword(password);
        Boolean validPassword = userService.validatePassword(encryptPassword,password);
        Assertions.assertEquals(true,validPassword);
    }

    @Test
    void generateTokenTest(){
        String expectedToken = "eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAyMi8wMi8wNSAwMzo1NzozMiIsInN1YiI6ImVtYWlsQHBydWViYS5jb20ifQ.Pkvx7Thu5rp41Ir-0wsfOpVZz5pvvac4LwM9GXs6tLg";
        String email = "email@prueba.com";
        String date = "2022/02/05 03:57:32";
        String generateToken = tokenService.generateToken(email,date);
        Assertions.assertEquals(expectedToken,generateToken);
    }

    @Test
    void validateTokenTest() {
        String entityToken = "eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAyMi8wMi8wNSAwMzo1NzozMiIsInN1YiI6ImVtYWlsQHBydWViYS5jb20ifQ.Pkvx7Thu5rp41Ir-0wsfOpVZz5pvvac4LwM9GXs6tLg";
        String bearerToken = "Bearer "+entityToken;
        String email = "email@prueba.com";
        String date = "2022/02/05 03:57:32";
        Boolean validToken = tokenService.validateToken(email,date,bearerToken,entityToken);
        Assertions.assertEquals(true,validToken);
    }

}
