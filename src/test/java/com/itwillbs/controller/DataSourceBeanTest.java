package com.itwillbs.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 1) 실행할건데~ 스프링에 제이유닛4라는 애 통해서 실행할거고~
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
// 2) 프로젝트 설정값들 중에서
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		// 3)위치 저장할건데~ 그 위치가 어디나면 여기~~ root-context.xml 여기~~~
		)
public class DataSourceBeanTest {
	
	// 멤버 변수 =====================================
	// 3. DB 연결 정보 객체 (DataSourcte) 주입
	@Autowired
	private DataSource ds;
	
	// 1. sqlSessionTemplate 객체 주입
//	@Autowired
//	private SqlSessionTemplate sqlTemplate;
	// 근데 ㄴ 얘 안하고~~ 얘로 할거 ㄱ
	//   와이랍니까,,,?? 둘이 상속 관계라,,ㅋ 업캐스팅 한 걸로 쓰는 게 더 낫다,,,, 결합도 낮추려고 이러시남~~ 
	@Inject
	private SqlSession sqlSession;
	
	

	private static final Logger log = LoggerFactory.getLogger(DataSourceBeanTest.class);
	
	// 멤버 변수 끝 =====================================
	
	
	
	
//	@Test
	public void 객체주입확인() {
		log.info("(♥♥♥♥♥ 객체주입확인) DataSource ds: " + ds);
	}
	
	
//	@Test
	public void 디비연결() {
		
		Connection con;
		try {
			con = ds.getConnection();
			log.info("(♥♥♥♥♥ 디비연결) Connection con: " + con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void sqlSessionTemplate_객체_확인() {
//		log.info("(♥♥♥♥♥ sqlSessionTemplate_객체_확인) sqlTemplate: " + sqlTemplate.toString());
		log.info("(♥♥♥♥♥ sqlSessionTemplate_객체_확인) sqlSession: " + sqlSession.toString());
		
	}
	
	
	
}
