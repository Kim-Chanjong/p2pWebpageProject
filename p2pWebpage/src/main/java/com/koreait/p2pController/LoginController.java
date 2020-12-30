package com.koreait.p2pController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.service.MemberService;
import com.koreait.vo.MemberVO;

@Controller
@SessionAttributes("login")
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	

	//로그인 처리
	@RequestMapping(value="/loginCheck")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo,HttpSession session) {
		
		boolean result = memberService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("login");
		
		if(result) {
			mav.addObject("msg","성공");
		}else {
			mav.addObject("msg","실패");
		}
		
		return mav;
	}
	
	//로그아웃 처리
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("msg", "logout");
		
		return mav;
	}
	
}


