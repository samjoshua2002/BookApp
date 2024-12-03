package com.book.entity;

import jakarta.persistence.*;

@Entity
public class Mentity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Userid;
	
	private String username;
	private long usernumber;
	private String useremail;
	private String userpassword;
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(long usernumber) {
		this.usernumber = usernumber;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public Mentity(int userid, String username, long usernumber, String useremail, String userpassword) {
		super();
		Userid = userid;
		this.username = username;
		this.usernumber = usernumber;
		this.useremail = useremail;
		this.userpassword = userpassword;
	}
	public Mentity() {
		super();
		
	}
	
	
	
}
