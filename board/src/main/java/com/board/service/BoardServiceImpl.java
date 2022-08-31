
package com.board.service;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.board.paging.PaginationInfo;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public boolean registerBoard(BoardDTO params) {
		int queryResult = 0;

		if (params.getIdx() == null) {// no가 존재하지 않으면 insert(신규등록)
			queryResult = boardMapper.insertBoard(params);
		} else {
			queryResult = boardMapper.updateBoard(params);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public BoardDTO getBoardDetail(Long idx) {
		return boardMapper.selectBoardDetail(idx);
	}

	@Override
	public boolean deleteBoard(Long idx) {
		int queryResult = 0;

		BoardDTO board = boardMapper.selectBoardDetail(idx);

		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardMapper.deleteBoard(idx);// db로 지우지는 않고 목록에 노출을 시키지 않는다
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	  public List<BoardDTO> getBoardList(BoardDTO params) {
	    List<BoardDTO> boardList = Collections.emptyList();

	    int boardTotalCount = boardMapper.selectBoardTotalCount(params);

	    PaginationInfo paginationInfo = new PaginationInfo(params);
	    paginationInfo.setTotalRecordCount(boardTotalCount);


	    params.setPaginationInfo(paginationInfo);

	    if (boardTotalCount > 0) {
	      boardList = boardMapper.selectBoardList(params);
	    }

	    return boardList;
	  }

}
