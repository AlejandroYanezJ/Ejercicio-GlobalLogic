package globallogic.ejercicio.service.impl;

import globallogic.ejercicio.exception.TokenValidationException;
import globallogic.ejercicio.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;

@Service
@Log4j2
public class TokenServiceImpl implements TokenService {

    private static final String TOKEN_KEY = "clave.secreta.encriptacion.token.123456";

    public String generateToken(String email, String date) {
        Claims claims = Jwts.claims();
        claims.put("created", date);
        JwtBuilder tokenJWT = Jwts
                .builder()
                .setClaims(claims)
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS256,TOKEN_KEY.getBytes());
        String tokenJWTString = tokenJWT.compact();
        System.out.println(tokenJWTString);
        return tokenJWTString;
    }

    public void validateToken(String email, String date, String token) throws TokenValidationException {
        String validationToken = generateToken(email,date);
        if (validationToken.equals(token)){
            log.info("Token Validado");
        }
        else{
            throw new TokenValidationException(401,"El token ingresado no es valido");
        }
    }

}
