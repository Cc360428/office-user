package com.office.user.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.office.user.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Hyper-Li
 * @title: TokenServer
 * @projectName office-user
 * @description: TODO
 * @date 2019.07.4.000414:54
 */
@Service("TokenServer")
public class TokenServer {
    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getAccount())// 将 账户 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
