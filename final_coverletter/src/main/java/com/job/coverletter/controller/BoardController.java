package com.job.coverletter.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job.coverletter.model.board.biz.BoardBiz;
import com.job.coverletter.model.board.dto.BoardDto;

@Controller
public class BoardController {
	// 게시판
	private Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardBiz boardBiz;
	
	//로그인 기능 완성되면 로그인 세션에 있는 아이디로 바꿔야됨
	String login = "mint@email.com";

	// 글목록
	@RequestMapping(value = "/BOARD_boardList.do")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardBiz.boardList());
		return "BOARD/boardList";
	}

	// 글작성 페이지
	@RequestMapping(value = "/BOARD_boardWriteForm.do", method = RequestMethod.GET)
	public String boardWriteForm() {
		return "BOARD/boardWrite";
	}

	// 글작성
	@RequestMapping(value = "/BOARD_boardWrite.do", method = RequestMethod.POST)
	public String boardWrite(@ModelAttribute("BoardDto") BoardDto dto) {
		// 글작성자 : 로그인 완성되면 로그인 세션 아이디로 바꿔야됨
		dto.setJoinemail(login);

		int res = boardBiz.boardInsert(dto);
		if (res > 0) {
			return "redirect:/BOARD_boardList.do";
		} else {
			return "redirect:/BOARD_boardWriteForm.do";
		}
	}

	// 글상세 + 댓글상세
	@RequestMapping(value = "/BOARD_boardDetail.do", method = RequestMethod.GET)
	public String boardDetail(Model model, @ModelAttribute("BoardDto") BoardDto dto) {
		// 글
		BoardDto boardDetail = boardBiz.boardDetail(dto);
		// 댓글
		List<BoardDto> replyList = boardBiz.replyList(dto);
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("replyList", replyList);
		return "BOARD/boardDetail";
	}

	// 글수정 페이지
	@RequestMapping(value = "/BOARD_boardUpdateForm.do")
	public String boardUpdateForm(Model model, int boardseq) {
		return "BOARD/boardUpdate";
	}

	// 글수정
	@RequestMapping(value = "/BOARD_boardUpdate.do")
	public String boardUpdate(@ModelAttribute("BoardDto") BoardDto dto) {

		return null;
	}

	// 글삭제
	@RequestMapping(value = "/BOARD_boardDelete.do")
	public String boardDelete(int groupno) {
		boardBiz.boardDelete(groupno);
		return "redirect:/BOARD/boardList.do";
	}

	// 댓글작성
	@RequestMapping(value = "/BOARD_replyInsert.do")
	public String replyInsert(@ModelAttribute("BoardDto") BoardDto dto, Model model) {
		// 댓글작성자 : 로그인 완성되면 로그인 세션 아이디로 바꿔야됨
		dto.setJoinemail(login);
		boardBiz.replyInsert(dto);

		return "redirect:/BOARD_boardDetail.do?boardseq="+ dto.getBoardseq() +"&groupno=" + dto.getGroupno();
	}

	// 대댓글작성
	@RequestMapping(value = "/BOARD_rereInsert.do")
	public String rereInsert(@ModelAttribute("BoardDto") BoardDto dto, int parentboardseq, Model model) {
		// 댓글작성자 : 로그인 완성되면 로그인 세션 아이디로 바꿔야됨
		dto.setJoinemail(login);
		boardBiz.rereInsert(dto);

		return "redirect:/BOARD_boardDetail.do?boardseq="+ parentboardseq +"&groupno=" + dto.getGroupno();
	}

	// 댓글삭제
	@RequestMapping(value = "/BOARD_replyDelete.do")
	public String replyDelete(@ModelAttribute("BoardDto") BoardDto dto, int parentboardseq, Model model) {
		boardBiz.replyDelete(dto.getBoardseq());

		return "redirect:/BOARD_boardDetail.do?boardseq="+ parentboardseq +"&groupno=" + dto.getGroupno();
	}

	// 에러
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public void errpage() throws Exception {
		logger.info("예외 발생");
		throw new Exception();
	}
}
