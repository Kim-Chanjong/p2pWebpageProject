package com.koreait.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.koreait.vo.MemberVO;

@Repository 
public class MemberDAO { 
	
	
	DataSource dataSource;

	public MemberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}
	}
	
	public void insert(MemberVO memberVO) {
		System.out.println("MvcboardDAO 클래스의 insert() 메소드 실행");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = dataSource.getConnection();
			String sql = "insert into member (id, passwd, nickname, email) " + 
						 "values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPasswd());
			pstmt.setString(3, memberVO.getNickname());
			pstmt.setString(4, memberVO.getEmail());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
	}
}



