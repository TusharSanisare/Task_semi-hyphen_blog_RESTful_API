package com.example.Blog_API.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;

public class JwtUtil {
  private static final String SECRET = "your_secret_key";
  private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
  private static final JWTVerifier VERIFIER = JWT.require(ALGORITHM).build();

  public static String generateToken(String username) {
    return JWT.create()
        .withSubject(username)
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(System.currentTimeMillis() + 864_000_00)) // 1 day expiration
        .sign(ALGORITHM);
  }

  public static String validateToken(String token) throws JWTVerificationException {
    DecodedJWT jwt = VERIFIER.verify(token);
    return jwt.getSubject();
  }
}
