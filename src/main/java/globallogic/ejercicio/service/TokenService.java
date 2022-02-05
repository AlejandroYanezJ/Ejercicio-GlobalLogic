package globallogic.ejercicio.service;

import globallogic.ejercicio.exception.TokenValidationException;

public interface TokenService {

    public String generateToken(String email, String date);

    public void validateToken(String email, String date, String token) throws TokenValidationException;

    }
