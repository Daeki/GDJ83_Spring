package com.winter.app.boards.qnas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.boards.BoardDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@GetMapping("list")
	public ModelAndView list(Pager pager, ModelAndView mv) throws Exception {
		List<BoardDTO> ar = qnaService.list(pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		return mv;
	}

	@GetMapping("detail")
	public String detail() throws Exception {
		return "board/detail";
	}

	@GetMapping("add")
	public String add() throws Exception {
		return "board/add";
	}

	@GetMapping("update")
	public String update() throws Exception {
		return "board/update";
	}

}
