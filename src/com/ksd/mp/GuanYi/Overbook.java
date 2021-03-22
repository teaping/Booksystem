package com.ksd.mp.GuanYi;

//³¬ÆÚÍ¼Êé
public class Overbook {
	private  String bookpublish;
	private Integer readerid;
	private String readername;
	private String readercardid;
	public String getBookpublish() {
		return bookpublish;
	}
	public void setBookpublish(String bookpublish) {
		this.bookpublish = bookpublish;
	}
	public Integer getReaderid() {
		return readerid;
	}
	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}
	public String getReadername() {
		return readername;
	}
	public void setReadername(String readername) {
		this.readername = readername;
	}
	public String getReadercardid() {
		return readercardid;
	}
	public void setReadercardid(String readercardid) {
		this.readercardid = readercardid;
	}
	public Overbook(String bookpublish, Integer readerid, String readername, String readercardid) {
		super();
		this.bookpublish = bookpublish;
		this.readerid = readerid;
		this.readername = readername;
		this.readercardid = readercardid;
	}
	public Overbook() {
		super();
	}
	
	
}
