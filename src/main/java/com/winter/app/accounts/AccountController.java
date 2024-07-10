package com.winter.app.accounts;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winter.app.members.MemberDTO;
import com.winter.app.trades.TradeDTO;
import com.winter.app.trades.TradeService;

@Controller
@RequestMapping("/account/*")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private TradeService tradeService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(AccountDTO accountDTO, HttpSession session) throws Exception {
		String name = ((MemberDTO) session.getAttribute("member")).getUserName();
		accountDTO.setUserName(name);
		int result = accountService.add(accountDTO);

		return "redirect:/";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(AccountDTO accountDTO, Model model) throws Exception {
		accountDTO = accountService.detail(accountDTO);
		model.addAttribute("dto", accountDTO);
	}

	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public void transfer() throws Exception {
	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String tranfer(TradeDTO tradeDTO) throws Exception {
		// tradeDTO : 계좌번호가 1개
		// 보내는 계좌 : accountNumber
		// 받는 계좌 : receiveNumber
		int result = tradeService.trade(tradeDTO);

		return "redirect:../member/mypage";
	}

}
