package com.itwillbs.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	// 멤버변수 ====================================
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	   // sqlSession 객체 주입 (DI) ,, from root-context.xml 마트에 있는 객체
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.itwillbs.mapper.BoardMapper";
	
	// 멤버변수 끝 ====================================
	
	
	
	// 1. 글쓰기 insertBoard
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		log.info("(♥♥♥♥♥ 1.insertBoard) Service가 호출함");
		log.info("(♥♥♥♥♥ 1.insertBoard) jsp -> Controller -> Service 거치면서 vo 잘 받아왔나? :  " + vo);
		
		log.info("(♥♥♥♥♥ 1.insertBoard) MyBatis.. boardMapper.xml 로 고고링");
		// SQL 실행 객체 == SqlSession 객체~~ 주입 
		//   올인원임~~ (디비 연결 + myBatis + 매퍼 + 자원 해제)
		int result = sqlSession.insert(NAMESPACE+".create", vo);
								// insert 메서드 리턴타입: int~~ 영향 받은 row 몇 행인가 그거 말하나 봄~
		
		if (result > 0) {
			log.info("(♥♥♥♥♥ 1.insertBoard) 글쓰기 DB 작업 완^^ 다시 서비스로 가욘");
		}
		
	}
	// 1. 글쓰기 insertBoard 끝
	
	
	
	// 2. 전체 글 목록 조회
	@Override
	public List<BoardVO> listAll() throws Exception {
		log.info("(♥♥♥♥♥ 2.listAll) Service가 호출함");
		
		// DB가서 글 목록 모든 정보 가져오기
		log.info("(♥♥♥♥♥ 2.listAll) mapper 갈 거");
		List<BoardVO> boardList = sqlSession.selectList(NAMESPACE+".listAll");
		
		log.info("(♥♥♥♥♥ 2.listAll) mapper 가서 DB 처리 하고 왔고요~~ -> Service로 리턴할 거");
		log.info("(♥♥♥♥♥ 2.listAll) 받아온 boardList.size: " + boardList.size());
		
		return boardList;
	}
	// 2. 전체 글 목록 조회 끝
	
	
	
	// 3. 글 1개 정보 가져오기 
	@Override
	public BoardVO getBoard(Integer bno) throws Exception {
		log.info("(♥♥♥♥♥ 3.getBoard) Service가 호출함");
//		BoardVO vo = sqlSession.selectOne(NAMESPACE+".read", bno);
							// selectOne? 리턴값은? 매핑된 object다~~ 
							// 뭐가 매핑됐는데? xml 파일에서 resultType에 적어놓은 거~~
							// 그게 뭔데? BoardVO ^^
		log.info("(♥♥♥♥♥ 3.getBoard) mapper 가서 DB 처리 + 동시에~~ Service로 리턴할 거");
		return sqlSession.selectOne(NAMESPACE+".read", bno); 
	}
	// 3. 글 1개 정보 가져오기 끝
	

	
	
}// class BoardDAOImpl
