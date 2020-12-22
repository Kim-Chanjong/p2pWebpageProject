package com.koreait.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.koreait.dao.MemberDAO;
import com.koreait.vo.MemberVO;

public class InsertService implements MemberService {


	
	@Override
	public void execute(Model model) {
		System.out.println("InsertService 클래스의 execute() 메소드 실행 - Model 사용");
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MemberVO memberVO = ctx.getBean("memberVO", MemberVO.class);	
		
		memberVO.setId(id);
		memberVO.setPasswd(passwd);
		memberVO.setNickname(nickname);
		memberVO.setEmail(email);

		MemberDAO memberDAO = ctx.getBean("memberDAO", MemberDAO.class);
		try {
			memberDAO.insert(memberVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
