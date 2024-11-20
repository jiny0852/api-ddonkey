package com.javaex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/api/**") // API 경로에 대해 CORS 허용
	            .allowedMethods("GET", "POST", "PUT", "DELETE")
	            .allowedOrigins("http://localhost:3000", "http://localhost:8000", "http://localhost:9000", "http://localhost:7000", "http://3.36.114.173:8000", "http://3.36.109.148:9000") // 출처 지정 (React 클라이언트)
	            .allowedHeaders("*") // 모든 헤더 허용
	            .exposedHeaders("Authorization") // 노출할 헤더 설정으어1
	            .allowCredentials(true); // 쿠키 허용
	}
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:C:\\javaStudy\\upload\\");
    }
    
}