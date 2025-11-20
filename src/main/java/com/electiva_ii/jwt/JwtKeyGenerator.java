package com.electiva_ii.jwt;

import java.security.Key;
import java.util.Base64;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtKeyGenerator {

    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println(base64Key);
    }

}
