package com.yuhan.first_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuhan.first_project.provider.UserRole;
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
    @GetMapping("/jwt/{data}")
    public String getJwt(
    @AuthenticationPrincipal UserRole userRole,    
    @PathVariable("data") String data 
    ){
        return mainService.getJwt(data);
    }
    @PostMapping("/jwt")
    public UserRole validJwt(
        @RequestBody String jwt
    ){
        return mainService.validJwt(jwt);
    }
    
}
