package com.ad.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @program: ad
 * @Date: 2020-04-25 15:54
 * @Author: code1990
 * @Description:
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //先情况转换器
        converters.clear();
        //设置统一的转换器 把返回的java对象统一转换为json格式
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
