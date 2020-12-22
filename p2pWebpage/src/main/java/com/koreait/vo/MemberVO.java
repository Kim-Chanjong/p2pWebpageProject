package com.koreait.vo;

import java.util.Date;

public class MemberVO {

	private String id;
	private String passwd;
	private String nickname;
	private String email;
	
	
	
	



	public MemberVO() { }
	public MemberVO(String id, String passwd, String nickname, String email) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.nickname = nickname;
		this.email = email;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passwd=" + passwd + ", nickname=" + nickname + ", email=" + email + "]";
	}







	
	
	

	

	
	
	

	
	
}