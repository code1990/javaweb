package com.javaxy.util;

import com.javaxy.constant.SystemConstant;
import com.javaxy.entity.CheckResult;
import io.jsonwebtoken.*;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @author wei
 * @description
 * @date 2020/2/28
 */
public class JwtUtils {

    /*签发JWT*/
    public static String createJWT(String id, String subject, long ttMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer("javaxy")
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey);
        if (ttMillis >= 0) {
            long expMillis = nowMillis + ttMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);//设置过期时间
        }
        return builder.compact();
    }

    /*验证JWT*/
    public static CheckResult validateJWT(String jwtStr) {
        CheckResult checkResult = new CheckResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
            checkResult.setErrCode(SystemConstant.JWT_ERRCODE_EXPIRE);
            checkResult.setSuccess(false);
        } catch (SignatureException e) {
            checkResult.setErrCode(SystemConstant.JWT_ERRCODE_FAIL);
            checkResult.setSuccess(false);
        } catch (Exception e) {
            checkResult.setErrCode(SystemConstant.JWT_ERRCODE_FAIL);
            checkResult.setSuccess(false);
        }
        return checkResult;
    }

    /*生成加密key*/
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(SystemConstant.JWT_SECERT);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /*解析JWT字符串*/
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    public static void main(String[] args) throws InterruptedException {
        // 后端生成token
        String sc = createJWT("1", "jack", SystemConstant.JWT_TTL);
        System.out.println(sc);

        // 后端验证token
        CheckResult checkResult = validateJWT(sc);
        System.out.println(checkResult.isSuccess());
        System.out.println(checkResult.getErrCode());
        Claims claims = checkResult.getClaims();
        System.out.println(claims);
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());

        // 刷新token 重新生成token
        Claims claims2 = validateJWT(sc).getClaims();
        String sc2 = createJWT(claims2.getId(), claims2.getSubject(), SystemConstant.JWT_TTL);
        System.out.println(sc2);
    }
}

