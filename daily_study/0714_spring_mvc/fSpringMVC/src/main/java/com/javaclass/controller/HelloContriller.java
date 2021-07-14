package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloContriller {
	@RequestMapping("start.do")
	public ModelAndView test() {
		System.out.println("start.do 확인");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("start");// /WEB-INF/views/+start+jsp
		mv.addObject("test","오늘도 화이팅");
		return mv;
		
	}

	
}
