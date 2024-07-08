package com.winter.app.members;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO) throws Exception {

		int result = memberService.join(memberDTO);

		return "redirect:/";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model, @CookieValue(name = "remember", required = false, defaultValue = "") String value)
			throws Exception {
		model.addAttribute("id", value);
//		Cookie[] cookies = request.getCookies();
//		for (Cookie c : cookies) {
//			if (c.getName().equals("remember")) {
//				request.setAttribute("id", c.getValue());
//			}
//		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO, String remember, HttpServletResponse response, HttpSession session)
			throws Exception {

		if (remember != null) {
			Cookie cookie = new Cookie("remember", memberDTO.getUserName());
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		// memberDTO = memberService.login(memberDTO);
		Map<String, Object> map = memberService.login(memberDTO);
		if (map != null) {
			session.setAttribute("member", map);
		} else {

		}
		return "redirect:/";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate(); // session의 유지시간을 0으로 설정
//		session.setAttribute("member", null);
//		session.removeAttribute("member");
//		session.removeValue("member");
//		session.isNew();
		return "redirect:../";
	}

	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void mypage(HttpSession session, Model model) throws Exception {
		// MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		// memberDTO = memberService.login(memberDTO);
		// model.addAttribute("member", memberDTO);

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO = memberService.login(memberDTO);
		model.addAttribute("member", memberDTO);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO, HttpSession session) throws Exception {
		MemberDTO user = (MemberDTO) session.getAttribute("member");
		memberDTO.setUserName(user.getUserName());
		int result = memberService.update(memberDTO);
//		if (result > 0) {
//			session.setAttribute("member", memberDTO);
//		}

		return "redirect:../";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		int result = memberService.delete(memberDTO);
		if (result > 0) {
			session.invalidate();
		}

		return "redirect:/";
	}

}
