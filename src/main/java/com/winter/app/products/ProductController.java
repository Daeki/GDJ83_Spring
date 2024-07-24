package com.winter.app.products;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.members.MemberDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@ModelAttribute("board")
	public String getBoard() {
		return "Product";
	}

	@GetMapping("deleteWishList")
	public String deleteWishList(Long[] bookNumber, Model model, HttpSession session) throws Exception {
		for (Long bn : bookNumber) {
			System.out.println(bn);
		}

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		int result = productService.deleteWishList(bookNumber, memberDTO.getUserName());
		model.addAttribute("msg", result);

		return "commons/result";
	}

	@GetMapping("wishList")
	public void wishList(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		List<ProductDTO> ar = productService.wishList(memberDTO);
		model.addAttribute("list", ar);
	}

	@GetMapping("addWish")
	public String addWish(Long bookNumber, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		int result = productService.addWish(bookNumber, memberDTO.getUserName());
		model.addAttribute("msg", result);
		return "commons/result";
	}

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
	public String add(ProductDTO productDTO, MultipartFile[] files, HttpSession session) throws Exception {

		int result = productService.add(productDTO, files, session);

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
