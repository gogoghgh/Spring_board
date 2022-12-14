package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.PageVO;

public interface BoardDAO {
	// 1. 글쓰기 insertBoard(vo)
	public void insertBoard(BoardVO vo) throws Exception;

	// 2. 글 전체 목록 조회
	public List<BoardVO> listAll() throws Exception;
	
	// 2-1. 페이징 처리 적용해서 목록 조회
	public List<BoardVO> listPage(Integer page) throws Exception;

	// 2-2. 페이징 처리 적용해서 목록 조회2
	public List<BoardVO> listPage(PageVO vo) throws Exception;

	// 3. 글 1개 정보 가져오기
	public BoardVO getBoard(Integer bno) throws Exception;

	// 3-1. 글 조회수 1 증가
	public void updateReadCount(Integer bno) throws Exception;
	
	// 4-1. 글 수정하기
	public Integer updateBoard(BoardVO vo) throws Exception;

	// 5. 글 삭제하기
	public int removeBoard(int bno) throws Exception;
	
}
