package com.office.user.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author Hyper-Li
 * @title: Jwt
 * @projectName office-user
 * @description: TODO
 * @date 2019.06.17.001720:35
 */
public class Jwt {
    // 过期时间
    private static final long EXPIRE_TIME = 5 * 60 * 100000;

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     *
     * @param username 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String secret) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (RuntimeException e) {
            return null;
        }
    }


//    public static void main(String[] args) {
//        String createToken;
//        createToken = sign("lcc", "lcc");
//        System.out.println("生成的token：" + createToken);
//        String getToken;
//        getToken = getUsername(createToken);
//        System.out.println("获取token中的值：" + getToken);
//        boolean ver;
//        ver = verify(createToken, "lcc", "lcc");
//        System.out.println("判断token中的用户名密码是否正确：" + ver);
//    }
}