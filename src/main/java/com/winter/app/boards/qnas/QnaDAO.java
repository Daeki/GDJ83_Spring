package com.winter.app.boards.qnas;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.boards.BoardDAO;
import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardFileDTO;
import com.winter.app.files.FileDTO;
import com.winter.app.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.winter.app.boards.qnas.QnaDAO.";

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + "list", pager);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "add", boardDTO);
	}

	@Override
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "addFile", boardFileDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + "update", boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + "delete", boardDTO);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "detail", boardDTO);
	}

	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "fileDetail", fileDTO);
	}

	public int reply(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "reply", qnaDTO);
	}

	public int replyUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "replyUpdate", qnaDTO);
	}

}
