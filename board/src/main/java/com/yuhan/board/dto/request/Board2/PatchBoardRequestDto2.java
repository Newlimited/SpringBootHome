package com.yuhan.board.dto.request.Board2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.yuhan.board.dto.request.Board.PatchBoardRequestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchBoardRequestDto2 {

    @NotNull //int 는 기본형 타입이라서 null이란 값을 받을 수 없다.
    // 그래서 Integer를 사용한다.
    private Integer boardNumber;  // 필수값으로 받기위해 Integer로  
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageUrl;

    public PatchBoardRequestDto2(PatchBoardRequestDto dto){
        this.boardNumber = dto.getBoardNumber();
        this.boardTitle = dto.getBoardTitle();
        this. boardContent = dto.getBoardContent();
        this. boardImageUrl = dto.getBoardImageUrl();
        
    }
}