 

package com.board.service;

import java.util.List;

import com.board.domain.BoardDTO;
 

public interface BoardService {
  public boolean registerBoard(BoardDTO params); // 게시글 등록 실패인지 성공인지 boolean로 리턴

  public BoardDTO getBoardDetail(Long idx); // 게시글번호 인자값

  public boolean deleteBoard(Long idx);

  public List<BoardDTO> getBoardList(BoardDTO params); // 목록조회 params - board테이블에 있는 정보
}