package com.itwillbs.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
// 이렇게 적어줘서~ junit을 통해 테스트할 수 있게 된다~~
//  테스트할 때 필요한 정보는? root-context.xml에서 가져오겠다~~
public class BoardDAOTest {
	
	// 멤버변수 =====================================
	private static final Logger log = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Autowired
	private BoardDAO dao; // 필요한 객체들,, new 해서 생성하지 않고,, 의존관계 주입~~!!!
						// 어디서 얘 가져오는 거?? root-context.xml에서,,, 
	// 멤버변수 끝 =====================================
	
	
	
//	@Test
	public void 테스트확인() {
		log.info("(♥♥♥♥♥ 테스트확인) 호출됨");
	}
	
	
	
	@Test
	public void 페이징처리완료() {
		log.info("(♥♥♥♥♥ 페이징처리완료) 호출됨");
		
		// DAOImpl_2-1.listPage() 호출하기... 하려면? DAO 객체가 필요!!(의존 관계^^)
		
		try {
			// dao.listPage() 호출하면 리턴값으로 리스트 객체 생기고 
			// --> 얘를 하나 꺼내서 바로 담을 수 있는 형태(BoardVO)
			 for(BoardVO vo : dao.listPage(1)) {
				 log.info("(♥♥♥♥♥ 페이징처리완료) bno + title: " + vo.getBno() + ":  " + vo.getTitle() );
			 };
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}// class BoardDAOTest
