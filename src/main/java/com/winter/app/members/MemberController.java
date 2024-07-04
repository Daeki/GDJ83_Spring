package com.winter.app.members;

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

		memberDTO = memberService.login(memberDTO);
		if (memberDTO != null) {
			session.setAttribute("member", memberDTO);
		} else {

		}
		return "redirect:/";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate(); // session의 유지시간을 0으로 설정
		return "redirect:../";
	}

}
