package com.sit.SoftwareProcess.SoftwareProcess.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sit.SoftwareProcess.SoftwareProcess.Model.User;
import org.springframework.stereotype.Service;

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
        String token = signer
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withClaim("email", user.getEmail())
                .sign(algorithmHS);
        return token;
    }
}
