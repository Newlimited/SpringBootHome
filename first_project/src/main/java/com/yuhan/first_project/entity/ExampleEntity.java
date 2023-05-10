package com.yuhan.first_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Example")
@Table(name= "Example")
public class ExampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // 열거형 IDENTITY를 지정해줌. => AUTO INCREMENT
    @Column(name = "exampleColumn1", nullable = false, unique = true)
    private int pk;
    private String exampleColumn2;
    private boolean exampleColumn3;
}
