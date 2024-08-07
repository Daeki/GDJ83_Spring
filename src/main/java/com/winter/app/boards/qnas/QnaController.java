package com.winter.app.boards.qnas;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.boards.BoardDTO;
import com.winter.app.files.FileDTO;
import com.winter.app.members.MemberDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board")
	public String getBoard() {
		return "Qna";
	}

	@GetMapping("list")
	public ModelAndView list(Pager pager, ModelAndView mv) throws Exception {
		List<BoardDTO> ar = qnaService.list(pager);
		mv.addObject("list", ar);

		mv.setViewName("board/list");
		return mv;
	}

	@GetMapping("detail")
	public String detail(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}

	@GetMapping("add")
	public String add() throws Exception {
		return "board/add";
	}

	@PostMapping("add")
	public String add(QnaDTO qnaDTO, MultipartFile[] files, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		qnaDTO.setBoardWriter(memberDTO.getUserName());

		int result = qnaService.add(qnaDTO, files, session);

		return "redirect:./list";
	}

	@GetMapping("update")
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/add";
	}

	@PostMapping("update")
	public String update(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.update(qnaDTO);
		return "redirect:./list";
	}

	@GetMapping("delete")
	public String delete(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.delete(qnaDTO);

		return "redirect:./list";
	}

	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception {
		model.addAttribute("boardDTO", qnaDTO);
		return "board/add";
	}

	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO, HttpSession session, MultipartFile[] files) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		qnaDTO.setBoardWriter(memberDTO.getUserName());
		int result = qnaService.reply(qnaDTO, files, session);
		return "redirect:./list";
	}

	@GetMapping("fileDown")
	public String fileDown(FileDTO fileDTO, Model model) throws Exception {
		fileDTO = qnaService.fileDetail(fileDTO);
		model.addAttribute("file", fileDTO);
		return "fileDown";
	}

}
