package com.winter.app.members;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.DefaultTest;

public class MemberDAOTest extends DefaultTest {

	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void loginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserName("goodee");
		memberDTO = memberDAO.login(memberDTO);

		assertEquals(2, memberDTO.getDtos().size());
	}

}
