package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {
	
	// 1. 글쓰기 
	public void boardWrite(BoardVO vo) throws Exception;
	
	// 2. 글 전체 목록 조회
	public List<BoardVO> getBoardListAll() throws Exception;

	// 3. 글 1개 정보 불러오기
	public BoardVO getBoard(Integer bno) throws Exception; 
	
	// 3-1. 글 조회수 1 증가
	public void updateReadCount(Integer bno) throws Exception;
	
	// 4-1. 글 수정하기
	public Integer updateBoard(BoardVO vo) throws Exception;
	
}
