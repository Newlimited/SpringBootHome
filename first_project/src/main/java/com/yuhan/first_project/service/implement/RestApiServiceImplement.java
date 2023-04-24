package com.yuhan.first_project.service.implement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RestApiServiceImplement implements RestApiService {
    
    @Override
    public String getMethod() {
        return "Return to Service Layer";
    }

}
