package com.winter.app.members;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.accounts.AccountDAO;
import com.winter.app.files.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private FileManager fileManager;

	private String name = "members";

	public int join(MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {

		int result = memberDAO.join(memberDTO);

		if (files == null) {
			return result;
		}

		ServletContext servletContext = session.getServletContext();
		// 1. 어디에 저장?? 운영체제가 알고 있는 경로
		String path = servletContext.getRealPath("resources/upload/members");

		System.out.println(path);

		String fileName = fileManager.fileSave(path, files);

		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setUserName(memberDTO.getUserName());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(files.getOriginalFilename());

		result = memberDAO.addFile(memberFileDTO);

		return result;// memberDAO.join(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {

		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getPassword().equals(memberDTO.getPassword())) {
				// 로그인 성공 지점

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

	public int delete(MemberDTO memberDTO) throws Exception {
		return memberDAO.delete(memberDTO);
	}

	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		return memberDAO.detail(memberDTO);
	}

}
