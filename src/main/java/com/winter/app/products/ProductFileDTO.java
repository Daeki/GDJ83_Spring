package com.winter.app.products;

import com.winter.app.files.FileDTO;

public class ProductFileDTO extends FileDTO {

	private Long bookNumber;

	public Long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(Long bookNumber) {
		this.bookNumber = bookNumber;
	}

}
