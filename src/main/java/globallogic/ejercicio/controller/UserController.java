package globallogic.ejercicio.controller;

import globallogic.ejercicio.dto.UserLoginRequestDTO;
import globallogic.ejercicio.dto.UserLoginResponseDTO;
import globallogic.ejercicio.dto.UserSignUpRequestDTO;
import globallogic.ejercicio.dto.UserSignUpResponseDTO;
import globallogic.ejercicio.exception.TokenValidationException;
import globallogic.ejercicio.exception.UserException;
import globallogic.ejercicio.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@NoArgsConstructor

public class UserController {

    @Autowired
    private UserService userService;

   @PutMapping(value = "/sign-up", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserSignUpResponseDTO> userSignUp(@Valid @RequestBody UserSignUpRequestDTO request) throws Exception {
       return new ResponseEntity<>(userService.registerUser(request),null, HttpStatus.CREATED);
   }

   @GetMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserLoginResponseDTO> userLogin(@RequestHeader(value = "Authorization") String token, @Valid @RequestBody UserLoginRequestDTO request) throws UserException, TokenValidationException {

       return new ResponseEntity<>(userService.loginUser(request,token),null,HttpStatus.OK);
   }

}
