package com.winter.app.accounts;

import java.sql.Date;

public class TradeDTO {
	// 거래번호
	private Long tradeNum;

	// 거래일
	private Date tradeDate;

	// 거래금액
	private Long tradeAmount;

	// 거래후 잔액
	private Long tradeBalance;

	// 입출금 구분, (0:입금, 1:출금)
	private Integer tradeIO;

	// 계좌번호
	private Long accountNumber;

	// 받는계좌번호
	private Long receiveNumber;

	public Long getReceiveNumber() {
		return receiveNumber;
	}

	public void setReceiveNumber(Long receiveNumber) {
		this.receiveNumber = receiveNumber;
	}

	public Long getTradeNum() {
		return tradeNum;
	}

	public void setTradeNum(Long tradeNum) {
		this.tradeNum = tradeNum;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Long getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(Long tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public Long getTradeBalance() {
		return tradeBalance;
	}

	public void setTradeBalance(Long tradeBalance) {
		this.tradeBalance = tradeBalance;
	}

	public Integer getTradeIO() {
		return tradeIO;
	}

	public void setTradeIO(Integer tradeIO) {
		this.tradeIO = tradeIO;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

}
