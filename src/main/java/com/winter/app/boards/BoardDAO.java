package com.winter.app.boards;

import java.util.List;

import com.winter.app.files.FileDTO;
import com.winter.app.util.Pager;

public interface BoardDAO {

	// NoticeDAO, QnaDAO

	// totalCount
	public Long getTotalCount(Pager pager) throws Exception;

	// list
	public abstract List<BoardDTO> list(Pager pager) throws Exception;

	// add
	public int add(BoardDTO boardDTO) throws Exception;

	public int addFile(BoardFileDTO boardFileDTO) throws Exception;

	// update
	int update(BoardDTO boardDTO) throws Exception;

	// delete
	int delete(BoardDTO boardDTO) throws Exception;

	// detail
	BoardDTO detail(BoardDTO boardDTO) throws Exception;

	// fileDetail
	FileDTO fileDetail(FileDTO fileDTO) throws Exception;

}
