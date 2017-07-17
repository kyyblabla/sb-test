package com.kyyblabla.test.secur.security;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kyy on 2017/7/13.
 */
@Slf4j
public class JwtUtil {


    public static enum Claims {
        EXP("exp"),
        IAT("iat"),
        TIME_OUT("timeOut"),
        DATA("data");

        private Claims(String key) {
            this.key = key;
        }

        private String key;

        public String getKey() {
            return key;
        }
    }

    public static String createToken(String secret, long expiresTime, Object data) {
        long iat = System.currentTimeMillis();
        long exp = iat + expiresTime;
        JWTSigner signer = new JWTSigner(secret);
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.EXP.key, exp);
        claims.put(Claims.IAT.key, iat);
        claims.put(Claims.TIME_OUT.key, expiresTime);
        claims.put(Claims.DATA.key, data);
        String jwt = signer.sign(claims);
        return jwt;
    }

    /**
     * 检查token
     *
     * @param secret 密钥
     * @param token
     * @return 合法时token返回内部包含数据，非法时返回null
     */
    public static Map<String, Object> verifyToken(String secret, String token) {
        try {
            JWTVerifier verifier = new JWTVerifier(secret);
            Map<String, Object> claims = verifier.verify(token);
            return claims;
        } catch (Exception e) {
            log.warn("token verifier error: ", e);
        }
        return null;
    }

}
