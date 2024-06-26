package com.winter.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {

	// IOC : Inversion Of Controll
	// 객체 생성, 메서드 호출
	// Controller, Service, Repository, Component
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("department list");
		// return "department/list
		List<DepartmentDTO> ar = departmentService.getList();

		// Model + View
		// ModelAndView mv = new ModelAndView();
		// mv.addObject("list", ar);
		// mv.setViewName("department/list");
		// return mv;

		model.addAttribute("list", ar);

		// return "department/list";
	}

	@RequestMapping("detail")
	// @RequestParam(name = "num", defaultValue = "10") int department_id
	public String getDetail(Model model, int department_id) throws Exception {

		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);

		String path = "commons/message";

		if (departmentDTO != null) {
			model.addAttribute("dto", departmentDTO);
			path = "department/detail";
		} else {
			model.addAttribute("result", "부서를 찾을 수 없다");
			model.addAttribute("url", "./list");
		}

		return path;

	}

	// add
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add2() {

	}

}
