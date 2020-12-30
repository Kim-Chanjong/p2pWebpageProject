package com.koreait.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.dao.MemberDAO;
import com.koreait.vo.MemberVO;

@Service
public class LoginService implements MemberService {

	@Autowired
	MemberDAO dao;
	
	@Override
	public boolean loginCheck(MemberVO vo,HttpSession session) {
		
		boolean result = dao.loginCheck(vo);
		if (result == true) {	//true 일경우 세션 등록
			//세션 변수 등록
			session.setAttribute("id",vo.getId());
		}
		
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		dao.logout(session);
	}
	
	
}