package com.javassem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.BoardDAOImpl;
import com.javassem.domain.BoardVO;


@Service("boardService")// 이름 맞춰주기
public class BoardServiceImpl implements BoardService {
	
	@Autowired//boardDAO 니가 알아서 자동으로 껴들어와라
	private BoardDAOImpl boardDAO;

	public void insertBoard(BoardVO vo) {

		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
}