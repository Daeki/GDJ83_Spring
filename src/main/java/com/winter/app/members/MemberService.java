package com.winter.app.members;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.accounts.AccountDAO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;

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

		File file = new File(path);

		if (!file.exists()) {
			file.mkdirs();
		}

		// 2. 파일명??
		// 1) 시간
		Calendar calendar = Calendar.getInstance();
		long n = calendar.getTimeInMillis();

		// subString
		String fileName = files.getOriginalFilename();
		fileName = fileName.substring(fileName.lastIndexOf("."));
		System.out.println(fileName);

		// split, StringTokenizer
		fileName = files.getOriginalFilename();
		String[] names = fileName.split("\\.");
		fileName = names[names.length - 1];

		System.out.println(fileName);
		fileName = n + "." + fileName;

		fileName = n + "_" + files.getOriginalFilename();

		// 2)
		fileName = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();
		System.out.println(fileName);

		// 3. HDD에 파일 저장
		file = new File(file, fileName);

		// 1) MultipartFile
		// files.transferTo(file);

		// 2) FileCopyUtils
		FileCopyUtils.copy(files.getBytes(), file);

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
