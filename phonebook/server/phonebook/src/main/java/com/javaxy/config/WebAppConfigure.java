package com.javaxy.config;

import com.javaxy.interceptor.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wei
 * @description
 * @date 2020/2/28
 */
@Configuration
public class WebAppConfigure implements WebMvcConfigurer {
    /*允许所有的跨域请求*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE","OPTIONS")
                .maxAge(3600);
    }

    /**
     * 配置不需要拦截的请求
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] patterns = new String[] {"/login","/*.html","/image"};
        registry.addInterceptor(new SysInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }
}

