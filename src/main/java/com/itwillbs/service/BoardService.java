package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.PageVO;

public interface BoardService {
	
	// 1. 글쓰기 
	public void boardWrite(BoardVO vo) throws Exception;
	
	// 2. 글 전체 목록 조회
	public List<BoardVO> getBoardListAll() throws Exception;
	
	// 2-1. 페이징 처리 적용한 글 목록 조회
	public List<BoardVO> getListPage(PageVO vo) throws Exception;

	// 3. 글 1개 정보 불러오기
	public BoardVO getBoard(Integer bno) throws Exception; 
	
	// 3-1. 글 조회수 1 증가
	public void updateReadCount(Integer bno) throws Exception;
	
	// 4-1. 글 수정하기
	public Integer updateBoard(BoardVO vo) throws Exception;

	// 5. 글 삭제하기
	public Integer removeBoard(int bno) throws Exception;
	
}
