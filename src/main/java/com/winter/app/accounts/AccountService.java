package com.winter.app.accounts;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public int add(AccountDTO accountDTO) throws Exception {
		Calendar calendar = Calendar.getInstance();
		accountDTO.setAccountNumber(calendar.getTimeInMillis());

		return accountDAO.add(accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return accountDAO.detail(accountDTO);
	}

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
		int result = accountDAO.addTrade(tradeDTO);
		System.out.println("step1");
		// 계좌내용을 업데이트
		result = accountDAO.updateTrade(tradeDTO);
		System.out.println("step2");
		// 받는 DTO로 수정

		tradeDTO.setTradeIO(0);
		// 받는 계좌 거래내역 추가
		result = accountDAO.addTrade(tradeDTO);
		System.out.println("step3");
		// 받는 계좌내용을 업데이트
		result = accountDAO.updateTrade(tradeDTO);
		System.out.println("step4");

		return result;
	}

	public List<TradeDTO> list(ListOption listOption) throws Exception {
		return accountDAO.list(listOption);
	}

}
