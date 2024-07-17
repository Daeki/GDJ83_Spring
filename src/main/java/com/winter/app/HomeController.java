package com.winter.app;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {

		System.out.println("Study_Conflict");

		// 1
		Calendar ca = Calendar.getInstance();

		long l = ca.getTimeInMillis();
		String s = String.valueOf(l);

		// 하위 -> 상위 O
		// 상위 -> 하위 X
		HttpSession session = request.getSession();

		// 배열 문법 데이터타입[]
//		Cookie[] cookies = request.getCookies();
//		for (Cookie c : cookies) {
//			System.out.println(c.getName());
//			System.out.println(c.getValue());
//		}

//		Cookie cookie = new Cookie("test", "DK");
//		cookie.setMaxAge(60);
//		response.addCookie(cookie);
		return "index";
	}

}
