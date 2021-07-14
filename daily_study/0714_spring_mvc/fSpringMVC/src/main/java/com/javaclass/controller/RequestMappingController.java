package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaclass.model.MemberVO;

@Controller
@RequestMapping("re")
public class RequestMappingController {
	
	@RequestMapping(value = {"/a.do", "/b.do"})
	public String test() {
		System.out.println("a.do 요청 확인");
		
		//1) ModelAndView 리턴
		
		
		//**************************************************************
		//2)리턴형이 String 인 경우,
		//값을 리턴하는 것이 아니라  뷰페이지로 지정한다
		//( 다음 화면이 view의 start.jsp가 된다)
		return "start";
	}
	
	@RequestMapping(value="/c.do")
	public void sample(String id) {
		//3)리턴형이 void인 경우
		//	요청명과 동일한 뷰페이지를 지정
		//	요청명:re/c.do
		System.out.println("이전 페이지로 부터 받은 데이터:"+id);
	}
	
	
	@RequestMapping(value= "/request.do", method=RequestMethod.POST)
	//post방식일 경우에만 적용
	
	//이전 화면(폼)에서 입력값을 얻어와서 MemberVO 객체의 멤버 저장
	
	public void request(@ModelAttribute("vo") MemberVO vo) {
	//public void request( MemberVO vo) {
		System.out.println("멤버의 아이디:" +  vo.getId());
	}
	
	
	@RequestMapping("/model.do")
	public void model(Model m) {
		/*
		 * 4)뷰단으로 Model객체에 데이터를 저장해서 넘김
		 * ************Model 변수 선언이 인자로 지정
		 */
		m.addAttribute("message", "오늘도 만세");
		m.addAttribute("data","스프링만세");
		
	}
	
	
	
	
	
	
	
}
