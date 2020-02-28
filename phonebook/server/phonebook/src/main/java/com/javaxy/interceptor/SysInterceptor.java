package com.javaxy.interceptor;

import com.javaxy.constant.SystemConstant;
import com.javaxy.entity.CheckResult;
import com.javaxy.entity.R;
import com.javaxy.util.JwtUtils;
import com.javaxy.util.StringUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wei
 * @description
 * @date 2020/2/28
 */
public class SysInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getRequestURI();
        System.out.println("路径:" + contextPath);
        String token = request.getHeader("token");
        if (handler instanceof HandlerMethod) {
            if (StringUtil.isEmpty(token)) {
                System.out.println("签名证书不存在");
                print(response, R.error(SystemConstant.JWT_ERRCODE_NULL, "签名验证不存在"));
                return false;
            } else {
                CheckResult checkResult = JwtUtils.validateJWT(token);
                if ((checkResult.isSuccess())) {
                    System.out.println("签名证书通过");
                    return true;
                } else {
                    switch (checkResult.getErrCode()) {
                        case SystemConstant.JWT_ERRCODE_FAIL:
                            System.out.println("签名验证不通过");
                            print(response, R.error(SystemConstant.JWT_ERRCODE_FAIL, "签名验证不通过"));
                            break;
                        case SystemConstant.JWT_ERRCODE_EXPIRE:
                            System.out.println("签名验证过期");
                            print(response, R.error(SystemConstant.JWT_ERRCODE_EXPIRE, "签名验证过期"));
                            break;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    private void print(HttpServletResponse response, Object message) {
        try {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setHeader("Cache-Control", "no-cache, must-revalidate");
            PrintWriter writer = response.getWriter();
            writer.write(message.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

