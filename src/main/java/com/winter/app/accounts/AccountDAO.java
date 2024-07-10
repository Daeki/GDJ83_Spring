package com.winter.app.accounts;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.winter.app.accounts.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountDTO);
	}

	public int addTrade(TradeDTO tradeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "addTrade", tradeDTO);
	}

	public int updateTrade(TradeDTO tradeDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateTrade", tradeDTO);
	}

	public List<TradeDTO> list(ListOption listOption) throws Exception {
		return sqlSession.selectList(NAMESPACE + "list", listOption);
	}

}
