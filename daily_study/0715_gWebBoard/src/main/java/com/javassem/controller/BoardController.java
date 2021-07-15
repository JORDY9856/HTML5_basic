package com.javassem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {

	@Autowired//객체를 하나 생성해줘
	private BoardService boardService;
	
	@RequestMapping("/getBoardList.do")
	public void getBoardList(Model m) {
		m.addAttribute("boardList",boardService.getBoardList());
	}//주소값이 같기 때문에 Model m 사용
	
	@RequestMapping("insertBoard.do")
	public void insertBoard() {	
	}
	
	
	@RequestMapping("saveBoard.do")
	public String saveBoard(BoardVO vo) {//redirect 는 String 리턴
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping("getBoard.do")
	public void getBoard(Model m,BoardVO vo) {
		m.addAttribute("board",boardService.getBoard(vo));
		
	}
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO vo ) {
		 boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
		
	}
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo ) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
		


}
