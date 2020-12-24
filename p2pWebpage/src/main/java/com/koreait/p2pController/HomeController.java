package com.koreait.p2pController;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.dao.MybatisDAO;
import com.koreait.service.MemberService;
import com.koreait.vo.MemberVO;

@Controller
public class HomeController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		System.out.println("프로젝트가 실행될 때 최초 요청을 받는 메소드");
		return "home";		// return "list"; -> return "home";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
		public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	public String list2() {
	return "list2";
	}
	
	@RequestMapping("/uploadPage")
	public String uploadPage(Locale locale, Model model) {
		System.out.println("컨트롤러의 uploadPage() 메소드 실행");
		return "uploadPage";
	}
	
	@RequestMapping("/fileUploadResult")
	public String fileUploadResult(MultipartHttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 fileUploadResult() 메소드 실행");
		String rootUploadDir = "C:" + File.separator + "Upload";
		File dir = new File(rootUploadDir + File.separator + "testfile");
		if (!dir.exists()) { 
			dir.mkdirs();
		}
		
		Iterator<String> iterator = request.getFileNames();
		String uploadFileName = "";
		MultipartFile multipartFile = null;
		String orgFileName = "";
		ArrayList<String> list = new ArrayList<String>();
		
		while (iterator.hasNext()) {
			uploadFileName = iterator.next();
			multipartFile = request.getFile(uploadFileName);
			orgFileName = multipartFile.getOriginalFilename();
			System.out.println(orgFileName);
			
			if (orgFileName != null && orgFileName.length() != 0) {
				try {
					multipartFile.transferTo(new File(dir + File.separator + orgFileName));
					System.out.println("원본 파일명 : " + orgFileName);
					list.add("원본 파일명 : " + orgFileName);
				} catch (Exception e) {
					e.printStackTrace();
					list.add("파일 업로드 중 에러 발생!!!");
				}
			}
		}
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 login() 메소드 실행");
		return "login";
	}
	
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 insert() 메소드 실행");
		return "insert";
	}
	


	
	@RequestMapping("/insertOK")
	public String insertOK(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 insertOK() 메소드 실행");
	
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MemberVO memberVO = ctx.getBean("memberVO", MemberVO.class);	
		
		memberVO.setId(request.getParameter("id"));
		memberVO.setPasswd(request.getParameter("passwd"));
		memberVO.setNickname(request.getParameter("nickname"));
		memberVO.setEmail(request.getParameter("email"));
		
		mapper.insert(memberVO);

		return "login";
	}
	

}