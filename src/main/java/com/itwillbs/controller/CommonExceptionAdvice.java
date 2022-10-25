package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {
	// 예외를 처리하는 보조 기능(객체)
	// @ControllerAdvice?? 다른 컨트롤러에서 발생한 예외(Exception)를 전문적으로 처리하는 객체!!
	
	// 멤버변수 ======================================
	private static final Logger log = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	// 멤버변수 끝 ======================================
	
	
//	@ExceptionHandler(Exception.class)
//	public void test() {
//		log.info("(♥♥♥♥♥ test) exception 발생하면 이 메서드 실행됨");
//		log.info("(♥♥♥♥♥ common) 리턴 타입 void");
//	}


	/*
	@ExceptionHandler(Exception.class)
	public String common(Exception e, Model model) {
		log.info("(♥♥♥♥♥ common) exception 발생하면 이 메서드 실행됨");
		log.info("(♥♥♥♥♥ common) 리턴 타입 String");
		log.info("(♥♥♥♥♥ common) e.getMessage(): " + e.getMessage());
		log.info("(♥♥♥♥♥ common) e.toString(): " + e.toString());
		
		// 연결된 뷰에 출력하고 싶어서^^ 모델 객체에 담기
		model.addAttribute("e", e.getMessage());
		
		return "commons";
		//오잉? 예외 발생했을 때 연결되는 뷰가 이 리턴값이넴?? WEB-INF/views/commons.jsp
	}
	*/
	
	// 모델 객체~ 컨트롤러랑 뷰 연결해주는~~~ 
	// 근데ㅡ,,,, 여기는 컨트롤러가 아니잖아요?? 그럼 뭘 써야 하나,,,,,,
	// ㄴ ModelAndView !!!! 모델 정보 + 뷰 연결시켜서 정보 보낼 수 있도록 제공해주는 객체,, 
	@ExceptionHandler(Exception.class)
	public ModelAndView common(Exception e) {
		log.info("(♥♥♥♥♥ common) exception 발생하면 이 메서드 실행됨");
		log.info("(♥♥♥♥♥ common) 리턴 타입 String");
		log.info("(♥♥♥♥♥ common) e.getMessage(): " + e.getMessage());
		log.info("(♥♥♥♥♥ common) e.toString(): " + e.toString());
		
		ModelAndView mav = new ModelAndView();
		// mav.setView("/commons"); // 실제 뷰 객체를 만들어서 전달할 때
		mav.setViewName("/commons"); // 뷰 이름이~ commons인~~ 뷰를 저장하것다
		// mav.addObject(attributeName, attributeValue);
		mav.addObject("e", e.getMessage());
		
		return mav;
		//오잉? 예외 발생했을 때 연결되는 뷰가 이 리턴값이넴?? WEB-INF/views/commons.jsp
	}
	
	
	

}
