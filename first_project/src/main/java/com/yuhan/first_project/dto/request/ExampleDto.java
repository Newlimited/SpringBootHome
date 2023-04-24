package com.yuhan.first_project.dto.request;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class ExampleDto {
 
    @NotBlank
    private String parameter1;
    @Length(min = 0, max= 20)
    private String parameter2;
    private String parameter3;
    // private 이기 때문에 다른 레이어에서 쓰려면 setter 와 getter 가 필요하다 . 
    // method를 만들지 않고 lombok의 어노테이션으로 간편하게 한다.
}