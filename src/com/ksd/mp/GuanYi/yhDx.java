package com.ksd.mp.GuanYi;

//用户对象
public class yhDx {
	private Integer userid;
	private String  username;
	private String userpassword;
	private String usertel;
	private String useraddress;
	private String userdate;
	private String userpurview;
	private String usertruce;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public String getUserdate() {
		return userdate;
	}
	public void setUserdate(String userdate) {
		this.userdate = userdate;
	}
	public String getUserpurview() {
		return userpurview;
	}
	public void setUserpurview(String userpurview) {
		this.userpurview = userpurview;
	}
	public String getUsertruce() {
		return usertruce;
	}
	public void setUsertruce(String usertruce) {
		this.usertruce = usertruce;
	}
	public yhDx(Integer userid, String username, String userpassword, String usertel, String useraddress,
			String userdate, String userpurview, String usertruce) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.usertel = usertel;
		this.useraddress = useraddress;
		this.userdate = userdate;
		this.userpurview = userpurview;
		this.usertruce = usertruce;
	}
	public yhDx() {
		super();
	}
	
	
}
