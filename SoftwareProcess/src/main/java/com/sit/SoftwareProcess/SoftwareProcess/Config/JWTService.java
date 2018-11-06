package com.sit.SoftwareProcess.SoftwareProcess.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sit.SoftwareProcess.SoftwareProcess.Model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Service
public class JWTService {
    public static Algorithm algorithmHS = Algorithm.HMAC256("secret");
    public static JWTVerifier verifier = JWT.require(algorithmHS).withIssuer("auth0").build();
    public static JWTCreator.Builder signer = JWT.create().withIssuer("auth0");

    public DecodedJWT verify(String token) {
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT;
    }

    public String encodeUser(User user) {
        JWTCreator.Builder signer = JWT.create().withIssuer("auth0");
        Date expireDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expireDate);
        calendar.add(Calendar.DATE, 7);
        expireDate = calendar.getTime();

        String token = signer
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withClaim("email", user.getEmail())
                .withExpiresAt(expireDate)
                .sign(algorithmHS);
        return token;
    }
}
