package com.kyyblabla.test.secur.security.helper;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.kyyblabla.test.secur.security.JwtUtil;
import com.kyyblabla.test.secur.security.bean.SessionUser;
import com.kyyblabla.test.secur.util.BeanMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kyy on 2017/7/13.
 */
@Component
public class JwtHelper {

    @Value("${jwtSecret?:'kyy'}")
    private String jwtSecret;

    @Value("${jwtExpiresTime?:3600000}")
    private long jwtExpiresTime;

    @Autowired
    private UserDetailsService userDetailsService;

    public String createToken(SessionUser sessionUser) {
        return JwtUtil.createToken(jwtSecret, jwtExpiresTime, sessionUser.getUsername());
    }

    public SessionUser verifyToken(String token) {
        Map<String, Object> stringObjectMap = JwtUtil.verifyToken(jwtSecret, token);
        if (stringObjectMap != null) {
            String username = String.valueOf(stringObjectMap.get("data"));
            return (SessionUser) userDetailsService.loadUserByUsername(username);
        }
        return null;
    }


}
