package com.yuhan.first_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.yuhan.first_project.filter.JwtAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    public WebSecurityConfig(
        JwtAuthenticationFilter jwtAuthenticationFilter
        ){
            this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        }
       
        @Bean
        
    //접근제어자
        protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.cors().and()
            .csrf().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                                                    //생성하지 않을거란 거임.
            .authorizeRequests().antMatchers("/jwt/**","/file/**").permitAll()
            .anyRequest().authenticated();
           
            httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
            return httpSecurity.build();            
        } 
        //jwtAuthenticationFilter 이전에 필터가 사용되어야 하기 때문에 
        //UsernamePasswordAuthenticationFilter.class 이것을 추가함


}
