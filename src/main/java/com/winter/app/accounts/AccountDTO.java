package com.winter.app.accounts;

import java.sql.Date;

import com.winter.app.members.MemberDTO;
import com.winter.app.products.ProductDTO;

public class AccountDTO {

	private Long accountNumber;
	private Long bookNumber;
	private String userName;
	private Date accountDate;
	private Long accountBalance;
	private MemberDTO memberDTO;
	private ProductDTO productDTO;

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(Long bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}

	public Long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}

}
