package com.esun.blog.utilities;

import java.util.Date;
import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/*
生成token generateToken(String username)
解析token getClaimsByToken(String token)
 */
public class JWTUtilies {

    // 7天后失效
    private static int accessTokenExpire = 604800;
    // 32位元key
    // private static String secrect = "kdorigjbms.zlxobieqh9g6nm29ek47c";

    // Generate a secure key for HS512
    private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    // 生成token和refresh token
    public static String generateAccessToken(int userId) {
        Date now = new Date();
        Date accessTokenExpireDate = new Date(now.getTime() + accessTokenExpire * 1000);

        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setSubject(String.valueOf(userId))
                .setIssuedAt(now)
                .setExpiration(accessTokenExpireDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    // 解析token
    public static Claims getClaimsByToken(String token) {

        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            System.err.println("Error token解析失敗");
            return null;
        }
    }
}