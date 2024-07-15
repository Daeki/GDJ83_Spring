package com.winter.app.boards;

import java.util.List;

import com.winter.app.util.Pager;

public interface BoardService {

	// list
	public List<BoardDTO> list(Pager pager) throws Exception;

	// add
	public int add(BoardDTO boardDTO) throws Exception;

	// update
	public int update(BoardDTO boardDTO) throws Exception;

	// delete
	public int delete(BoardDTO boardDTO) throws Exception;

	// detail
	public BoardDTO detail() throws Exception;

}
