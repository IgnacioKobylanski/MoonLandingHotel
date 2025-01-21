package com.moonlandinghotel.moon_landing_hotelweb.security.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // Clave secreta para firmar el JWT
    private String secretKey = "yourSecretKey";

    // Tiempo de expiración del JWT (ejemplo: 1 hora)
    private long validity = 3600000L;

    // Método para generar un JWT
    public String generateToken(String username) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);  // Usando el algoritmo HMAC256 con la clave secreta

        return JWT.create()
                .withSubject(username)  // Asignamos el username como el sujeto del token
                .withIssuedAt(new Date())  // Fecha de emisión
                .withExpiresAt(new Date(System.currentTimeMillis() + validity))  // Fecha de expiración
                .sign(algorithm);  // Firmamos el token con el algoritmo y la clave secreta
    }

    // Método para validar y obtener el usuario desde el token
    public String extractUsername(String token) {
        DecodedJWT decodedJWT = decodeToken(token);
        return decodedJWT.getSubject();
    }

    // Método para verificar si el token está expirado
    public boolean isTokenExpired(String token) {
        Date expirationDate = extractExpirationDate(token);
        return expirationDate.before(new Date());
    }

    // Método para obtener la fecha de expiración del token
    private Date extractExpirationDate(String token) {
        DecodedJWT decodedJWT = decodeToken(token);
        return decodedJWT.getExpiresAt();
    }

    // Método para validar un token
    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }

    // Método privado para decodificar el token
    private DecodedJWT decodeToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.require(algorithm)
                .build()
                .verify(token);
    }
}