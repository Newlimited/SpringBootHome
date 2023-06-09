package com.yuhan.board.service;

import org.springframework.http.ResponseEntity;

import com.yuhan.board.dto.request.Board.PatchBoardRequestDto;
import com.yuhan.board.dto.request.Board2.PatchBoardRequestDto2;
import com.yuhan.board.dto.request.Board2.PostBoardRequestDto2;
import com.yuhan.board.dto.request.Board.PostBoardRequestDto;
import com.yuhan.board.dto.response.ResponseDto;
import com.yuhan.board.dto.response.board.GetBoardListResponseDto;
import com.yuhan.board.dto.response.board.GetBoardResponseDto;

public interface BoardService {
    
    public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto);
    public ResponseEntity<ResponseDto> postBoard(String userEmail, PostBoardRequestDto2 dto);
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList();
    public ResponseEntity<? super GetBoardListResponseDto> getBoardTop3();

    public ResponseEntity<ResponseDto> patchBoard(PatchBoardRequestDto dto);
    public ResponseEntity<ResponseDto> patchBoard(String userEmail, PatchBoardRequestDto2 dto);

    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber);
    
}
