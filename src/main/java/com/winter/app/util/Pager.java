package com.winter.app.util;

import java.util.HashMap;
import java.util.Map;

public class Pager {

	// 컬럼종류
	private String kind;
	// 검색어
	private String search;

	private Long startRow;
	private Long lastRow;

	// 페이징 처리 하는 메서드

	public Map<String, Object> makeNum(long totalCount, long perPage, long page) throws Exception {

		// 1. 총갯수를 이용해서 총 페이지수 구하기
		long totalPage = totalCount / perPage;
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

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("totalPage", totalPage);
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);
		map.put("pre", pre);
		map.put("next", next);

		return map;

	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

}
