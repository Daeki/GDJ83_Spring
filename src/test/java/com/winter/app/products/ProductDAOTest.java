package com.winter.app.products;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {

	@Autowired
	private ProductDAO productDAO;

	@Test
	public void pageTest() {
		long perPage = 10L;
		long totalCount = 80;// 120 , 130, 121~129 , 131~139
		long totalPage = totalCount / perPage;

		if (totalCount % perPage != 0) {
			totalPage++;
		}

		System.out.println(totalPage);
	}

	// @Test
	public void addTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		for (int i = 0; i < 100; i++) {
			productDTO.setBookName("자유입출금" + i);
			double r = ((int) (Math.random() * 1000)) / 100.0;
			productDTO.setBookRate(r);
			productDTO.setBookDetail("상세설명" + i);
			productDAO.add(productDTO);
			Thread.sleep(500);
		}
		System.out.println("Fisnish");
	}

	// @Test
	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBookNumber(100L);
		productDTO = productDAO.getDetail(productDTO);
		// 단정문
		assertNotNull(productDTO);

	}

}
