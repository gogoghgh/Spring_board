package com.itwillbs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.PageVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	// 멤버변수 ====================================================
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDAO dao;
	
	// 멤버변수 끝 ====================================================
	
	
	
	
	// 1. 글쓰기 boardWrite
	@Override
	public void boardWrite(BoardVO vo) throws Exception {
		log.info("(♥♥♥♥♥ 1.boardWrite) 컨트롤러가 호출함");
		
		log.info("(♥♥♥♥♥ 1.boardWrite) DAO 호출할거");
		// Service  -->  DAO_insertBoard(vo) 호출
		dao.insertBoard(vo);
		
		log.info("(♥♥♥♥♥ 1.boardWrite) DAO 갔다 왔고 -> Service(지금 여기) -> 컨트롤러로 갈게요");
		
	}
	// 1. 글쓰기 boardWrite 끝
	
	
	
	// 2. 전체 글 목록 조회 getBoardListAll
	@Override
	public List<BoardVO> getBoardListAll() throws Exception {
		log.info("(♥♥♥♥♥ 2.getBoardListAll) 컨트롤러가 호출함");
		
		log.info("(♥♥♥♥♥ 2.getBoardListAll) DAO_listAll() 호출할 거");
		List<BoardVO> boardList = dao.listAll();
		
		log.info("(♥♥♥♥♥ 2.getBoardListAll) DAO한테 결과 데이터 받았으니 --> Controller로 돌려줄게욥");
		
		return boardList;
	}
	// 2. 전체 글 목록 조회 getBoardListAll 끝
	
	
	// 2-1. 페이징 처리 적용한 글 목록 조회 getListPage
	@Override
	public List<BoardVO> getListPage(PageVO vo) throws Exception {
		log.info("(♥♥♥♥♥ 2-1.getListPage) 컨트롤러가 호출함");
		
		log.info("(♥♥♥♥♥ 2-1.getListPage) DAO_listPage(vo) 호출할 거");
		List<BoardVO> boardList = dao.listPage(vo);
		
		log.info("(♥♥♥♥♥ 2-1.getListPage) DAO한테 결과 데이터 받았으니 --> Controller로 돌려줄게욥");
		
		return boardList;
	}
	// 2-1. 페이징 처리 적용한 글 목록 조회 getListPage 끝
	
	
	
	// 3. 글 1개 정보 불러오기 getBoard
	@Override
	public BoardVO getBoard(Integer bno) throws Exception {
		log.info("(♥♥♥♥♥ 3.getBoard) 컨트롤러가 호출함");
		
		log.info("(♥♥♥♥♥ 3.getBoard) DAO_getBoard 호출할 거 --> 리턴받고 바로 컨트롤러로 갈 거");
		return dao.getBoard(bno);
	}
	// 3. 글 1개 정보 불러오기 getBoard 끝
	
	
	
	// 3-1. 조회수 1 증가 updateReadCount 
	@Override
	public void updateReadCount(Integer bno) throws Exception {
		log.info("(♥♥♥♥♥ 3-1.updateReadCount) 컨트롤러가 호출함");
		
		log.info("(♥♥♥♥♥ 3-1.updateReadCount) DAO 호출할 거");
		dao.updateReadCount(bno);
		
		log.info("(♥♥♥♥♥ 3-1.updateReadCount) DAO 갔다 왔구요~ Controller로 돌아갈게요");
	}
	// 3-1. 조회수 1 증가 updateReadCount 끝
	
	
	
	// 4-1. 글 수정하기
	@Override
	public Integer updateBoard(BoardVO vo) throws Exception {
		log.info("(♥♥♥♥♥ 4-1.updateBoard) 컨트롤러가 호출함");
		
		log.info("(♥♥♥♥♥ 4-1.updateBoard) DAO 호출할 거");
		int cnt = dao.updateBoard(vo);
		
		log.info("(♥♥♥♥♥ 4-1.updateBoard) DAO 갔다 왔구요~ Controller로 돌아갈게요 cnt: " + cnt);
		return cnt;
	}
	// 4-1. 글 수정하기 끝
	
	
	
	// 5. 글 삭제하기 
	@Override
	public Integer removeBoard(int bno) throws Exception {
		log.info("(♥♥♥♥♥ 5.removeBoard) 컨트롤러가 호출함");
		
		log.info("(♥♥♥♥♥ 5.removeBoard) DAO 호출할 거");
		int cnt = dao.removeBoard(bno);
		
		log.info("(♥♥♥♥♥ 5.removeBoard) DAO 갔다 왔구요~ Controller로 돌아갈게요 cnt: " + cnt);
		return cnt;
	}
	// 5. 글 삭제하기 끝
	
	
	
	
} // class BoardServiceImpl
