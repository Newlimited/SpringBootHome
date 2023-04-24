package com.yuhan.first_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuhan.first_project.service.MainService;
import com.yuhan.first_project.service.implement.MainServiceImplement;


@RestController
public class MainController {
    
    private final MainService mainService; {
        
    };
    
    @Autowired
    public MainController(MainService mainService){
        this.mainService = mainService;
    }
    @GetMapping("/hello")
    public String hello(){
        return mainService.hello();
    }
}
