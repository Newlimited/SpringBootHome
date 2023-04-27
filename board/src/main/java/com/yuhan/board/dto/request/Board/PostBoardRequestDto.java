package com.yuhan.board.dto.request.Board;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class PostBoardRequestDto {
    
    @NotBlank
    @Email
    private String boardWirterEmail;
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageUrl;

}
