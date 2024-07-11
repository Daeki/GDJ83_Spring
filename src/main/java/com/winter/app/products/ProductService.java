package com.winter.app.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;

	public List<ProductDTO> getList(Long page) throws Exception {
		// page가 1 2 3 4
		// 첫번째 숫자 1 11 21 31
		// 두번째 숫자 10 20 30 40
		// 5
		if (page == null) {
			page = 1L;
		}
		long perPage = 10L;
		long startRow = (page - 1) * perPage + 1;
		long lastRow = page * perPage;

		List<Long> ar = new ArrayList<Long>();
		ar.add(startRow);
		ar.add(lastRow);

		Map<String, Long> map = new HashMap<String, Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);

		Pager pager = new Pager();
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);

		long totalCount = productDAO.getTotalCount();// 120 , 130, 121~129 , 131~139
		long totalPage = totalCount / perPage;

		if (totalCount % perPage != 0) {
			totalPage++;
		}

		System.out.println(totalPage);

		return productDAO.getList(pager);
	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getDetail(productDTO);
	}

	public int add(ProductDTO productDTO) throws Exception {
		return productDAO.add(productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}

}
