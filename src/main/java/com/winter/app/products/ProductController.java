package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		List<ProductDTO> ar = productService.getList();

		model.addAttribute("list", ar);
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.getDetail(productDTO);

		model.addAttribute("dto", productDTO);
	}

}
