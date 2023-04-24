package com.yuhan.first_project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class ExampleResponseDto {
    
    private String data1;
    private String data2;
    private String data3;

}