package com.winter.app.boards.notices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winter.app.boards.BoardDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Pager pager, Model model) throws Exception {
		List<BoardDTO> list = noticeService.list(pager);
		model.addAttribute("list", list);

		return "board/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "board/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);
		return "redirect:./list";

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/add";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		return "redirect:./list";

	}
}
