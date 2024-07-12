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
		long totalPage = totalCount / perPage;

		// 1. 총갯수를 이용해서 총 페이지수 구하기
		if (totalCount % perPage != 0) {
			totalPage++;
		}

		// 2. 총페이지수로 총블럭수 구하기
		long perBlock = 5L; // 한페이지에 보여질 페이지번호의 갯수

		long totalBlock = 0; // 총블럭의 수

		totalBlock = totalPage / perBlock;

		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		// 3. 현재페이지번호로 현재블럭 번호를 구하기

		// page 1 2 3 4 5 6 7 10 11
		// 블럭번호 1 1 1 1 1 2 2 2 3
		long curBlock = 0;
		curBlock = page / perBlock;

		if (page % perBlock != 0) {
			curBlock++;
		}

		// 4. 현재 블럭 번호로 시작번호와 끝 번호 구하기

		// curBlock 1 2 3
		// start 1 6 11
		// last 5 10 15
		long startNum = (curBlock - 1) * perBlock + 1;
		long lastNum = curBlock * perBlock;

		// 5. 이전블럭, 다음 블럭 유무 판단
		boolean pre = true; // true면 이전블럭이 존재, false면 이전블럭이 X
		boolean next = true;// true면 다음블럭이 존재, false면 다음블럭이 X
		if (curBlock == 1) {
			pre = false;
		}

		if (curBlock == totalBlock) {
			next = false;

			lastNum = totalPage;
		}

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("list", productDAO.getList(pager));
		map2.put("totalPage", totalPage);
		map2.put("startNum", startNum);
		map2.put("lastNum", lastNum);
		map2.put("pre", pre);
		map2.put("next", next);
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
