package com.javaex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**") // 경로 - api주소 붙은것만 허용
				.allowedMethods("GET", "POST", "PUT", "DELETE") //fetch같은걸로 오면 안됨
				.allowedOrigins("http://localhost:8080");// vue에서 쓴 주소 포트번호 일치해야 허용
	}
}
