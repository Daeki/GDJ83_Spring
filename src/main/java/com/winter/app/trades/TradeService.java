package com.winter.app.trades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.accounts.AccountDAO;
import com.winter.app.accounts.AccountDTO;

@Service
public class TradeService {

	@Autowired
	private TradeDAO tradeDAO;

	@Autowired
	private AccountDAO accountDAO;

	public int trade(TradeDTO tradeDTO) throws Exception {
		// 1번계좌에서 5000을 1720399116921계좌로 이체
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNumber(tradeDTO.getAccountNumber());
		accountDTO = accountDAO.detail(accountDTO);

		if (accountDTO.getAccountBalance() < tradeDTO.getTradeAmount()) {
			return 0;
		}

		// 거래내역 추가
		tradeDTO.setTradeIO(1);
		int result = tradeDAO.add(tradeDTO);
		System.out.println("step1");
		// 계좌내용을 업데이트
		result = tradeDAO.update(tradeDTO);
		System.out.println("step2");
		// 받는 DTO로 수정

		tradeDTO.setTradeIO(0);
		// 받는 계좌 거래내역 추가
		result = tradeDAO.add(tradeDTO);
		System.out.println("step3");
		// 받는 계좌내용을 업데이트
		result = tradeDAO.update(tradeDTO);
		System.out.println("step4");

		return result;
	}

}
