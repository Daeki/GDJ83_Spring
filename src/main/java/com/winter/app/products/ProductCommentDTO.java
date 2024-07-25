package com.winter.app.products;

import com.winter.app.boards.CommentDTO;

public class ProductCommentDTO extends CommentDTO {

	private Long bookNumber;

	public Long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(Long bookNumber) {
		this.bookNumber = bookNumber;
	}

}
