package com.winter.app.accounts;

public class ListOption {

	private Long accountNumber;

	private Integer order; // 0 desc, 1 asc

	private Integer io;// 0 입금, 1 출금, 그외 전체

	public Integer getIo() {
		return io;
	}

	public void setIo(Integer io) {
		this.io = io;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}
