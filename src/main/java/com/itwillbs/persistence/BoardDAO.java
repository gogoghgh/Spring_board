package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	// 1. 글쓰기 insertBoard(vo)
	public void insertBoard(BoardVO vo) throws Exception;

	// 2. 글 전체 목록 조회
	public List<BoardVO> listAll() throws Exception;

	// 3. 글 1개 정보 가져오기
	public BoardVO getBoard(Integer bno) throws Exception;
	
	
	
}