package com.winter.app.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	public int join(MemberDTO memberDTO) throws Exception {

		return memberDAO.join(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getPassword().equals(memberDTO.getPassword())) {
				return result;
			} else {
				// return null;
				result = null;
			}
		}

		return result;
	}

	public int update(MemberDTO memberDTO) throws Exception {
		return memberDAO.update(memberDTO);
	}

}
