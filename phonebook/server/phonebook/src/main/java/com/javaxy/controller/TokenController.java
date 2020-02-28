package com.javaxy.controller;

import com.javaxy.constant.SystemConstant;
import com.javaxy.entity.R;
import com.javaxy.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wei
 * @description
 * @date 2020/2/28
 */
@RestController
@RequestMapping("/")
public class TokenController {
    private final Logger logger= LoggerFactory.getLogger(TokenController.class);

    @GetMapping(value="/refreshToken")
    public R refreshToken(HttpServletRequest request){
        Claims claims = JwtUtils.validateJWT(request.getHeader("token")).getClaims();
        String newToken = JwtUtils.createJWT(claims.getId(),claims.getSubject(), SystemConstant.JWT_TTL);
        R r = new R();
        r.put("token",newToken);
        logger.info("新token:"+newToken);
        return r;
    }

}

