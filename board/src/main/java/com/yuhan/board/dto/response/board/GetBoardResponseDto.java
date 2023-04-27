package com.yuhan.board.dto.response.board;
import java.util.List;
import com.yuhan.board.dto.response.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetBoardResponseDto  extends ResponseDto{
    
    private Integer boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImageUrl;
    private String boardWriteDatetime;
    private int viewCount;
    private String boardWriterEmail;
    private String boardWriterprofileImageUrl;
    private List<Comment> commentList;
    private List<Liky> likeList;
}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
   
class Comment{
        private int commentNumber;
        private int boardNumber;
        private String commentWriterEmail;
        private String commentContent;
        private String commentWrtierNickname;
        private String commentWriterProfileImageUrl;
        private String commentWriteDatetime;
    }
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
    

class Liky{
        private int boardNumber;
        private String userEmail;
        private String userNickname;
        private String userProfileImageUrl;
            }
