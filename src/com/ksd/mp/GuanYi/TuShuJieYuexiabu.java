package com.ksd.mp.GuanYi;

import java.util.Date;

public class TuShuJieYuexiabu {
	private int readerid;
	private String bookcode;
	private Date borrowdate;
	private Date returndate;
	public int getReaderid() {
		return readerid;
	}
	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}
	public String getBookcode() {
		return bookcode;
	}
	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}
	public Date getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	@Override
	public String toString() {
		return "TuShuJieYuexiabu [readerid=" + readerid + ", bookcode="
				+ bookcode + ", borrowdate=" + borrowdate + ", returndate="
				+ returndate + "]";
	}
	
	
	
	
}
