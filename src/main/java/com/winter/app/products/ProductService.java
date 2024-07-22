package com.winter.app.products;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.files.FileManager;
import com.winter.app.util.Pager;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileManager fileManager;

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
