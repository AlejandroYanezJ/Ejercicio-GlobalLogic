package globallogic.ejercicio.service.impl;

import globallogic.ejercicio.config.Constant;
import globallogic.ejercicio.service.TokenService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Service
public class TokenServiceImpl implements TokenService {

    public String generateToken(String email, String date) {
        JwtBuilder tokenJWT = Jwts
                .builder()
                .setSubject(email+" " + date)
                .signWith(SignatureAlgorithm.HS256,generalKey());
        String tokenJWTString = tokenJWT.compact();
        System.out.println(tokenJWTString);
        return tokenJWTString;
    }


    public static byte[] generalKey() {
        byte[] encodedKey = Base64.encodeBase64("clave.secreta.encriptacion.token.123456".getBytes(StandardCharsets.UTF_8));
        return encodedKey;
    }

}
