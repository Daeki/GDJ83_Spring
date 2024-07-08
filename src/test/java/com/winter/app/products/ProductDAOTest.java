package com.winter.app.products;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {

	@Autowired
	private ProductDAO productDAO;

	@Test
	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBookNumber(100L);
		productDTO = productDAO.getDetail(productDTO);
		// 단정문
		assertNotNull(productDTO);

	}

}
