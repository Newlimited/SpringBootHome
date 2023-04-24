

package com.yuhan.first_project.service.implement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yuhan.first_project.service.MainService;

@Service
public class MainServiceImplement  implements MainService{

    @Override
    public String hello() {
        return "Hello syh";
    }
}