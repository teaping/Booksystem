package com.ksd.mp.GuanYi;

public class Chaoqts {
	private String bookcode;
	private String bookname;
	private String booksort;
	private String bookpublish;
	private int readerid;
	private String readername;
	private String readercardid;
	private String tsq;
	private String returndate;
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public String getTsq() {
		return tsq;
	}
	public void setTsq(String tsq) {
		this.tsq = tsq;
	}
	public String getBookcode() {
		return bookcode;
	}
	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBooksort() {
		return booksort;
	}
	public void setBooksort(String booksort) {
		this.booksort = booksort;
	}
	public String getBookpublish() {
		return bookpublish;
	}
	public void setBookpublish(String bookpublish) {
		this.bookpublish = bookpublish;
	}
	public int getReaderid() {
		return readerid;
	}
	public void setReaderid(int readerid) {
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
	public Chaoqts(){super();}
	@Override
	public String toString() {
		return "chaoqts [bookcode=" + bookcode + ", bookname=" + bookname
				+ ", booksort=" + booksort + ", bookpublish=" + bookpublish
				+ ", readerid=" + readerid + ", readername=" + readername
				+ ", readercardid=" + readercardid + "]";
	}
	public Chaoqts(String bookcode, String bookname, String booksort,
			String bookpublish, int readerid, String readername,
			String readercardid) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.booksort = booksort;
		this.bookpublish = bookpublish;
		this.readerid = readerid;
		this.readername = readername;
		this.readercardid = readercardid;
	}
	public Chaoqts( String bookname, String booksort,
			String bookpublish, int readerid, String readername,
			String readercardid) {
		super();
		this.bookname = bookname;
		this.booksort = booksort;
		this.bookpublish = bookpublish;
		this.readerid = readerid;
		this.readername = readername;
		this.readercardid = readercardid;
	}
	
	
}
