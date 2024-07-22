package com.winter.app.products;

import java.util.List;

public class ProductDTO {

	private Long bookNumber;
	private String bookName;
	private Double bookRate;
	private Integer bookSale;
	private String bookDetail;
	private List<ProductFileDTO> fileDTOs;

	public List<ProductFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<ProductFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}

	public Long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(Long bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getBookRate() {
		return bookRate;
	}

	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}

	public Integer getBookSale() {
		return bookSale;
	}

	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}

	public String getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}

}
