package com.yuhan.board.dto.response.board;

import java.util.List;

import com.yuhan.board.dto.response.ResponseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class GetBoardListResponseDto extends ResponseDto{
    private List<BoardSummary> boardList;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class BoardSummary {
   
    private Integer boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImageUrl;
    private String boardWriteDatetime;
    private int viewCount;
    private String boardWriterEmail;
    private String boardWriterprofileImageUrl;
    private int commentCount;
    private int likeCount;
}
