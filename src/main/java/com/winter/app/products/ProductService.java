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

	public Map<String, Object> getList(Long page, String kind, String search) throws Exception {
		// page가 1 2 3 4
		// 첫번째 숫자 1 11 21 31
		// 두번째 숫자 10 20 30 40
		// 5
		if (page == null) {
			page = 1L;
		}

		if (page < 1) {
			page = 1L;
		}

		if (search == null) {
			search = "";
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
		pager.setKind(kind);
		pager.setSearch(search);

		long totalCount = productDAO.getTotalCount(pager);// 120 , 130, 121~129 , 131~139

		// Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map2 = pager.makeNum(totalCount, perPage, page);

		map2.put("list", productDAO.getList(pager));

		map2.put("kind", kind);
		map2.put("search", search);
		return map2;
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
