package com.yuhan.board.dto.request.Board2;

import javax.validation.constraints.NotBlank;

import com.yuhan.board.dto.request.Board.PostBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostBoardRequestDto2{
    
    
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageUrl;

    public PostBoardRequestDto2(PostBoardRequestDto dto){
        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
        this.boardImageUrl = dto.getBoardImageUrl();
    }
}
