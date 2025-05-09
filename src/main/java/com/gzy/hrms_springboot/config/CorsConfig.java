package com.gzy.hrms_springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//@Configuration
//public class CorsConfig {
//
//    // 当前跨域请求最大有效时长。这里默认1天
//    private static final long MAX_AGE = 24 * 60 * 60;
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("http://localhost:8080"); // 1 设置访问源地址
//        corsConfiguration.addAllowedHeader("*"); // 2 设置访问源请求头
//        corsConfiguration.addAllowedMethod("*"); // 3 设置访问源请求方法
//        corsConfiguration.setMaxAge(MAX_AGE);
//        source.registerCorsConfiguration("/**", corsConfiguration); // 4 对接口配置跨域设置
//        return new CorsFilter(source);
//    }
//}


@Configuration
public class CorsConfig {

    // 当前跨域请求最大有效时长。这里默认1天
    private static final long MAX_AGE = 24 * 60 * 60;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 允许所有来源
        corsConfiguration.addAllowedOriginPattern("*");

        // 允许所有请求头
        corsConfiguration.addAllowedHeader("*");

        // 允许所有请求方法
        corsConfiguration.addAllowedMethod("*");

        // 允许携带凭证信息（如 Cookie）
        corsConfiguration.setAllowCredentials(true);

        // 设置预检请求的缓存时间
        corsConfiguration.setMaxAge(MAX_AGE);

        // 对所有接口配置跨域设置
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(source);
    }
}