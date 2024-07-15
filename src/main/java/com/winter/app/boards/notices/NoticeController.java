package com.winter.app.boards.notices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winter.app.boards.BoardDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Pager pager) throws Exception {
		List<BoardDTO> list = noticeService.list(pager);
		return "board/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.POST)
	public void detail(NoticeDTO noticeDTO) throws Exception {
		BoardDTO boardDTO = noticeService.detail();
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(NoticeDTO noticeDTO) throws Exception {

	}
}
