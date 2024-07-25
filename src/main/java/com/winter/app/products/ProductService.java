package com.winter.app.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.files.FileManager;
import com.winter.app.members.MemberDTO;
import com.winter.app.util.Pager;
import com.winter.app.util.ProductCommentPager;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileManager fileManager;

	public int commentDelete(ProductCommentDTO productCommentDTO) throws Exception {
		return productDAO.commentDelete(productCommentDTO);
	}

	public List<ProductCommentDTO> commentList(ProductCommentPager productCommentPager) throws Exception {
		productCommentPager.makeRow();
		System.out.println(productDAO);
		System.out.println(productCommentPager);
		Long t = productDAO.commentTotalCount(productCommentPager);
		System.out.println(t);
		productCommentPager.makeNum(productDAO.commentTotalCount(productCommentPager));
		return productDAO.commentList(productCommentPager);
	}

	public int commentAdd(ProductCommentDTO productCommentDTO) throws Exception {
		return productDAO.commentAdd(productCommentDTO);
	}

	public int deleteWishList(Long[] bookNumber, String userName) throws Exception {
		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("ids", bookNumber);
		result = productDAO.deleteWishList(map);
//		for (Long bn : bookNumber) {
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("bookNumber", bn);
//			map.put("userName", userName);
//			result = productDAO.deleteWishList(map);
//		}
		return result;
	}

	public List<ProductDTO> wishList(MemberDTO memberDTO) throws Exception {
		return productDAO.wishList(memberDTO);
	}

	public int addWish(Long bookNumber, String userName) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookNumber", bookNumber);
		map.put("userName", userName);

		return productDAO.addWish(map);

	}

	public List<ProductDTO> getList(Pager pager) throws Exception {
		// page가 1 2 3 4
		// 첫번째 숫자 1 11 21 31
		// 두번째 숫자 10 20 30 40
		// 5

		pager.makeRow();

		long totalCount = productDAO.getTotalCount(pager);// 100 , 130, 121~129 , 131~139

		pager.makeNum(totalCount);

		return productDAO.getList(pager);
	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getDetail(productDTO);
	}

	public int add(ProductDTO productDTO, MultipartFile[] files, HttpSession session) throws Exception {

		Long num = productDAO.getNum();

		productDTO.setBookNumber(num);

		int result = productDAO.add(productDTO);

		if (files == null) {
			return result;
		}

		// 1. 저장할 폴더 지정
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/products");
		System.out.println(path);

		for (MultipartFile f : files) {
			if (f.isEmpty()) {
				continue;
			}

			// 2. 저장할 파일명 생성
			String fileName = fileManager.fileSave(path, f);
			// 4. 파일정보를 DB에 저장
			// 파일명, 오리지널, 파일번호, 제품id
			ProductFileDTO productFileDTO = new ProductFileDTO();
			productFileDTO.setFileName(fileName);
			productFileDTO.setOriName(f.getOriginalFilename());
			productFileDTO.setBookNumber(num);
			result = productDAO.addFile(productFileDTO);

		}

		return result;
	}

	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}

}
