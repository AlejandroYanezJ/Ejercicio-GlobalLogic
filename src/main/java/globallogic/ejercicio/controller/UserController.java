package globallogic.ejercicio.controller;

import globallogic.ejercicio.dto.UserDTO;
import globallogic.ejercicio.dto.UserResponseDTO;
import globallogic.ejercicio.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@NoArgsConstructor

public class UserController {

    @Autowired
    private UserService userService;


   @PutMapping(value = "/sign-up", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserResponseDTO> userSignUp(@Valid @RequestBody UserDTO request){
       return ResponseEntity.ok(userService.registerUser(request));
   }

}
