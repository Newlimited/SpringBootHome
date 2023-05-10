package com.yuhan.first_project.service;

import org.springframework.stereotype.Component;

import com.yuhan.first_project.provider.UserRole;

@Component
public interface MainService {
    public String hello();
    public String getJwt(String data);
    public UserRole validJwt(String jwt);
}
