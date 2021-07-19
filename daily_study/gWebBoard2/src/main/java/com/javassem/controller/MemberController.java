package com.javassem.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.dao.MemberDAO;
import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;

@Controller
@RequestMapping("/user/")
public class MemberController {
	
	@RequestMapping("{url}.do") //변수로 하나 잡아서 고스란히 넘김
	//("/userJoin.do")
	public String sample(@PathVariable String url) {
		return "/user/"+url;
		
	}
	
	/*
	 * @RequestMapping("userInsert.do")//user/userInsert.do 실제 페이지 기준 public void
	 * insert(MemberVO memberVO) { System.out.println("userInsert.do 요청");
	 * System.out.println(memberVO.getUserId());
	 * System.out.println(memberVO.getUserName()); }
	 */
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("userInsert.do")
	public ModelAndView insert(MemberVO memberVO) {
		int result = memberService.userInsert(memberVO);
		
		String message="가입되지 않았습니다";
		if(result > 0) message =  memberVO.getUserName()+"님, 가입을 축하합니다";
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userJoin_ok"); 
		mv.addObject("result",result);
		mv.addObject("message",message);
		return mv;
	}
	
	
	
	@RequestMapping("login.do")
	public String login(MemberVO vo, HttpSession session) {
		/*
		 * 1. 사용자 입력값 받아오기
		 * 2. DB에 해당 정보가 있는지 확인
		 * 3. 해당 정보가 있다면, (로그인 성공시) /user/Main.jsp 뷰페이지 지정
		 * 4. 그렇지 않다면,(로그인 실패시) /user/userLogin.jsp 뷰페이지 지정
		 */
		 MemberVO result= memberService.idCheck_Login(vo);
		 if(result==null || result.getUserId()==null) {
			
			 return  "/user/userLogin";
		 
		 }else {//로그인 성공
			 session.setAttribute("userName", result.getUserId());
			 session.setAttribute("sessionTime", new Date());
			 return "/user/Main";
		 }
	}

	@RequestMapping(value="idCheck.do", 
			produces="application/text;charset=UTF-8")
//보낼때와 받을 때 둘다 한글처리

	@ResponseBody//리턴이 ajax인 경우*****************************
	 public String idCheck(MemberVO vo) {
		MemberVO result =  memberService.idCheck_Login(vo);
		String message = "사용가능한 아이디 입니다";
		if( result != null)message="이미 사용중인 아이디 입니다";
		return message;
	}
}

