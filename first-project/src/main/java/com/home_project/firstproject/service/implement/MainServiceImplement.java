package com.home_project.firstproject.service.implement;

import org.springframework.stereotype.Service;

import com.home_project.firstproject.service.MainService;

@Service
public class MainServiceImplement implements MainService {

    @Override
    public String hello(){
        return "Hello syh";
    }
    
}
