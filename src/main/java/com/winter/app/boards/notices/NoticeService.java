package com.winter.app.boards.notices;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.boards.BoardDAO;
import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardFileDTO;
import com.winter.app.boards.BoardService;
import com.winter.app.files.FileManager;
import com.winter.app.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		// 1. rownum 계산
		pager.makeRow();
		// 2. pageing 계산
		pager.makeNum(boardDAO.getTotalCount(pager));
		return boardDAO.list(pager);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		int result = boardDAO.add(boardDTO);
		String path = session.getServletContext().getRealPath("resources/upload/Notice");

		if (multipartFiles == null) {
			return result;
		}

		for (MultipartFile f : multipartFiles) {
			if (f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, f);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(f.getOriginalFilename());
			result = boardDAO.addFile(boardFileDTO);
		}

		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.detail(boardDTO);
	}

}
