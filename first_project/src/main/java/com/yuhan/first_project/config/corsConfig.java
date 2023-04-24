package com.yuhan.first_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //기본 설정을 맞춰주는것 
public class corsConfig implements WebMvcConfigurer{
    public void addCorsMappings(CorsRegistry registry){
        registry
        .addMapping("/**")// 어떠한 Path에 대해서 허용할 것인지 적어주는거 
        .allowedMethods("*")
        .allowedOrigins("*");
        
        // (/**) 모든 path를 허용 
        // allowedMethods = 어떤 Method들을 허용할 것인지
        // allowedOrigins = 어떤 출처에 대해서 허용할 것인지
        // 어떤것인지는 * = 모두 이므로 *대신에 특정 path를 넣으면된다.
    }
}
