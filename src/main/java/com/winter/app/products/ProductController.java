package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winter.app.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Pager pager, Model model) throws Exception {
		List<ProductDTO> list = productService.getList(pager);

		model.addAttribute("pager", pager);
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.getDetail(productDTO);

		model.addAttribute("dto", productDTO);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "product/form";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(ProductDTO productDTO) throws Exception {

		int result = productService.add(productDTO);

		return "redirect:./list";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.getDetail(productDTO);
		model.addAttribute("dto", productDTO);
		return "product/form";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ProductDTO productDTO) throws Exception {
		int result = productService.update(productDTO);
		return "redirect:./list";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(ProductDTO productDTO) throws Exception {
		int result = productService.delete(productDTO);
		return "redirect:./list";
	}

}
