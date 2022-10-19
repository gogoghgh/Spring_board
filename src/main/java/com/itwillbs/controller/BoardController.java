package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	// 멤버변수 ============================================
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	   // 서비스 객체 필요~ root-context.xml 마트에 있는 거 주입하기
	@Inject
	private BoardService service;
	
	// 멤버변수 끝 ============================================
	
	
	
	// 테스트..
	@RequestMapping (value = "/test", method = RequestMethod.GET)
	public void test() {
		log.info("(♥♥♥♥♥ test) 호출됨");
	}
	// 테스트 완
	
	
	
	// 1. 글쓰기 GET                       http://localhost:8080/board/regist
	@RequestMapping (value = "/regist", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		log.info("(♥♥♥♥♥ 1.registerGET) 호출됨");
		log.info("(♥♥♥♥♥ 1.registerGET) 리턴타입 void라서 /board/regist.jsp 로 이동할게요");
	}
	// 1. 글쓰기 GET 끝
	
	
	
	// 1-2. 글쓰기 POST                       http://localhost:8080/board/regist
	@RequestMapping (value="/regist", method = RequestMethod.POST)
//	public String registerPOST(BoardVO vo, Model model) throws Exception {  (알림 방법2)
	public String registerPOST(BoardVO vo, RedirectAttributes rttr) throws Exception {
		log.info("(♥♥♥♥♥ 1-2.registerPOST) 호출됨");
		
		// 한글 처리(web.xml에 필터 걸어놨으니까 할 필요 X ^^ 따봉 스프링)
		// 전달된 정보 저장
		log.info("(♥♥♥♥♥ 1-2.registerPOST) 들어온 정보 BoardVO: " + vo);
		
		// 컨트롤러 -> 서비스 호출 (글쓰기 동작,, 메서드,,)
		log.info("(♥♥♥♥♥ 1-2.registerPOST) Service 호출할게요");
		service.boardWrite(vo);
		
		log.info("(♥♥♥♥♥ 1-2.registerPOST) DAO -> Service갔다가 -> Controller로 다시 왔음,, 글쓰기 완!!");
		
		// 페이지 이동(글 목록으로)
		
//		model.addAttribute("msg", "OK");     // (알림 방법2)
		rttr.addFlashAttribute("msg", "OK"); // (알림 방법3) // 일회성 데이터임!! 체크용~ URL에 표시 X
			// 글쓰기 성공 알림 띄우기 위해서,, 
			//  방법1. 주소줄에 직접 보내기
			//  방법2. 모델 객체에 담아서 보내기
			//  방법3. 모델 객체 대신 RedirectAttributes 객체 쓰기!! for flash.. 글쓰기 성공 알림=일회성이니까 
		
//		return "redirect:/board/listAll?msg=OK"; // (알림 방법1)
		return "redirect:/board/listAll"; // 주소줄 변화 O + 페이지 이동 O
	}
	// 1-2. 글쓰기 POST 끝
	
	
	
	// 2. 게시판 리스트 조회 GET                  http://localhost:8080/board/listAll
	@RequestMapping (value = "/listAll", method = RequestMethod.GET)
	public void listAllGET(@ModelAttribute("msg") String msg, Model model) throws Exception {
		log.info("(♥♥♥♥♥ 2.listAllGET) 호출됨");
		
		// 리스트로 가는 경우의 수
		// 1. 글쓰고 나서 -> 리스트로 이동하는 경우
			log.info("(♥♥♥♥♥ 2.listAllGET) msg: " + msg);
			// 연결된 view 페이지로 저기서(1-2.registerPOST) 넘어온 정보 전달해보기
			// 이거 안 해도 넘어가는딩?
			model.addAttribute("msg", msg);
		
		// 2. 걍 바로 리스트로 이동하는 경우
		
		log.info("(♥♥♥♥♥ 2.listAllGET) Service 호출할게욘");
		List<BoardVO> boardList = service.getBoardListAll();
		
		log.info("(♥♥♥♥♥ 2.listAllGET) Service로부터 정보 받아옴^^ boardList.size: " + boardList.size());
		
		model.addAttribute("boardList", boardList);
		log.info("(♥♥♥♥♥ 2.listAllGET) 모델 객체에 저장 완");
		
		log.info("(♥♥♥♥♥ 2.listAllGET) /board/listAll 주소줄에 들어왔고 --> /board/listAll.jsp로 이동할 거");
	}
	// 2. 게시판 리스트 조회 GET 끝
	
	
	
	// 3. 글 본문 보기 GET
	@RequestMapping (value = "/read", method = RequestMethod.GET)
//	public void readGET(@ModelAttribute("bno") int bno) throws Exception{  (방법1. modelAttri로 받기)
	public void readGET(@RequestParam("bno") int bno, Model model) throws Exception{  // (방법2. requestParam으로 받기)
		log.info("(♥♥♥♥♥ 3.readGET) 호출됨");
		
		// 직전 페이지(listAll.jsp)에서 전달된 정보(bno) 저장
		// request 아니고 model로,,^^
//		log.info("(♥♥♥♥♥ 3.readGET) 넘어온 bno: " + request.getAttribute("bno"));
		log.info("(♥♥♥♥♥ 3.readGET) 넘어온 bno: " + bno);
		
		log.info("(♥♥♥♥♥ 3.readGET) Service 호출할게욘");
		BoardVO vo = service.getBoard(bno);
		
		log.info("(♥♥♥♥♥ 3.readGET) Service로부터 정보 받아옴^^ 받아온 vo: " + vo);
		
		// 모델 객체에 저장~ jsp 뷰 페이지에서 이 정보 쓸라고
		model.addAttribute("vo", vo);
		
		log.info("(♥♥♥♥♥ 3.readGET) 주소줄에 /board/read --> /board/read.jsp로 이동할 거");
	}
	// 3. 글 본문 보기 GET 끝
	
	
	
	
	
}// class BoardController
